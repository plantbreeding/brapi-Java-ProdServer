package org.brapi.test.BrAPITestServer.repository.core;

import org.brapi.test.BrAPITestServer.model.entity.core.ListEntity;
import org.brapi.test.BrAPITestServer.repository.BrAPIRepositoryImpl;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.hibernate.jpa.QueryHints;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class ListRepositoryImpl extends BrAPIRepositoryImpl<ListEntity, String> implements ListRepository{

    private EntityManager entityManager;

    public ListRepositoryImpl(JpaEntityInformation<ListEntity, String> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Page<ListEntity> findAllBySearchAndNotDeleted(SearchQueryBuilder<ListEntity> searchQuery, Pageable pageReq) {
        searchQuery = applyUserId(searchQuery);
        List<ListEntity> content = getPagedContent(searchQuery, pageReq);
        Long totalCount = getTotalCount(searchQuery);

        Page<ListEntity> page = new PageImpl<>(content, pageReq, totalCount);

        return page;
    }

    @Override
    public Optional<ListEntity> findByIdAndNotDeleted(String id) {
        Optional<ListEntity> response = findByIdNotDeletedNoAuthCheck(id);
        if (response.isPresent()) {
            String userId = getCurrentUserId();
            if (!(null == response.get().getAuthUserId()
                    || userId.equals(response.get().getAuthUserId())
                    || "anonymousUser".equals(response.get().getAuthUserId()))) {
                response = Optional.empty();
            }
        }
        return response;
    }

    private SearchQueryBuilder<ListEntity> applyUserId(SearchQueryBuilder<ListEntity> searchQuery) {

        SecurityContext context = SecurityContextHolder.getContext();
        Set<String> userRolesSet = context.getAuthentication().getAuthorities().stream()
                .map(auth -> auth.getAuthority()).collect(Collectors.toSet());

        List<String> userIds = new ArrayList<>();
        userIds.add(getCurrentUserId());
        if (userRolesSet.contains("ROLE_ADMIN")) {
            return searchQuery;
        } else if (userRolesSet.contains("ROLE_USER")) {
            userIds.add("anonymousUser");
        }

        searchQuery.appendList(userIds, "authUserId");

        return searchQuery;
    }

    private String getCurrentUserId() {
        SecurityContext context = SecurityContextHolder.getContext();
        String userId = "";
        if (context.getAuthentication().getPrincipal() != null) {
            userId = context.getAuthentication().getPrincipal().toString();
        }
        return userId;
    }

    private List<ListEntity> getPagedContent(SearchQueryBuilder<ListEntity> searchQuery, Pageable pageReq) {
        TypedQuery<ListEntity> query = entityManager.createQuery(searchQuery.getQuery(), searchQuery.getClazz());
        query.setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false);

        for (Entry<String, Object> entry : searchQuery.getParams().entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }

        query.setFirstResult((int) pageReq.getOffset());
        query.setMaxResults(pageReq.getPageSize());
        query.setParameter("softDeleted", false);

        List<ListEntity> content = query.getResultList();
        return content;
    }

    private Long getTotalCount(SearchQueryBuilder<ListEntity> searchQuery) {
        String countQueryStr = searchQuery.getQuery()
                .replaceFirst("(select|Select|SELECT)( distinct)? ([^\\s]*) ", "select count($2 $3) ")
                .replaceAll("LEFT JOIN FETCH", "LEFT JOIN")
                .replaceFirst("(order by|Order By|ORDER BY) .*", "");

        TypedQuery<Long> query = entityManager.createQuery(countQueryStr, Long.class);
        for (Entry<String, Object> entry : searchQuery.getParams().entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }

        List<Long> content = query.getResultList();
        if (content.size() > 0) {
            return content.get(0);
        }
        return 0L;
    }
}
