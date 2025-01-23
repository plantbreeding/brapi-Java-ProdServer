package org.brapi.test.BrAPITestServer.repository.core;

import org.brapi.test.BrAPITestServer.model.entity.core.CropEntity;
import org.brapi.test.BrAPITestServer.repository.BrAPIRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CropRepository extends BrAPIRepository<CropEntity, UUID>{
	public Page<CropEntity> findByCropName(String cropName, Pageable pageRequest);
}
