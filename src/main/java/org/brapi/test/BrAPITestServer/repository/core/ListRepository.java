package org.brapi.test.BrAPITestServer.repository.core;

import org.brapi.test.BrAPITestServer.model.entity.core.ListEntity;
import org.brapi.test.BrAPITestServer.repository.BrAPIRepository;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ListRepository extends BrAPIRepository<ListEntity, String>{
    @Modifying
    @Transactional
    @Query("UPDATE ListEntity l SET l.softDeleted = :softDeleted WHERE l.id = :listId")
    int updateSoftDeletedStatus(@Param("listId") String listId, @Param("softDeleted") boolean softDeleted);

    @Modifying
    @Transactional
    @Query("UPDATE ListEntity l SET l.softDeleted = :softDeleted WHERE l.id IN :listIds")
    int updateSoftDeletedStatusBatch(@Param("listIds") List<String> listIds, @Param("softDeleted") boolean softDeleted);
}