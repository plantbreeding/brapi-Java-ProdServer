package org.brapi.test.BrAPITestServer.repository.core;

import org.brapi.test.BrAPITestServer.model.entity.pheno.TraitEntity;
import org.brapi.test.BrAPITestServer.repository.BrAPIRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TraitRepository extends BrAPIRepository<TraitEntity, String> {
}
