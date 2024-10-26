package org.brapi.test.BrAPITestServer.repository.core;

import org.brapi.test.BrAPITestServer.model.entity.core.ListEntity;
import org.brapi.test.BrAPITestServer.repository.BrAPIRepository;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ListRepository extends BrAPIRepository<ListEntity, String>{
    public Page<ListEntity> findAllBySearchAndNotDeleted(SearchQueryBuilder<ListEntity> searchQuery, Pageable pageReq);

    @Query("SELECT l FROM ListEntity l WHERE l.id = :id AND l.softDeleted = false")
    public Optional<ListEntity> findByIdNotDeletedNoAuthCheck(String id);

    public Optional<ListEntity> findByIdAndNotDeleted(String id);

}
