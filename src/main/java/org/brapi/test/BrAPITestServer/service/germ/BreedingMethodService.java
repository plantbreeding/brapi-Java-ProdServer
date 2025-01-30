package org.brapi.test.BrAPITestServer.service.germ;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerDbIdNotFoundException;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.germ.BreedingMethodEntity;
import org.brapi.test.BrAPITestServer.repository.germ.BreedingMethodRepository;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.germ.BreedingMethod;

@Service
public class BreedingMethodService {
	
	private final BreedingMethodRepository breedingMethodRepository;
	
	public BreedingMethodService(BreedingMethodRepository breedingMethodRepository) {
		this.breedingMethodRepository = breedingMethodRepository;
	}

	public List<BreedingMethod> findBreedingMethods(Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		Page<BreedingMethodEntity> page = breedingMethodRepository.findAll(pageReq);
		List<BreedingMethod> breedingMethods = page.map(this::convertFromEntity).getContent();
		PagingUtility.calculateMetaData(metadata, page);
		return breedingMethods;
	}

	public BreedingMethod getBreedingMethod(String breedingMethodDbId) throws BrAPIServerException {
		return convertFromEntity(getBreedingMethodEntity(breedingMethodDbId, HttpStatus.NOT_FOUND));
	}

	public BreedingMethodEntity getBreedingMethodEntity(String breedingMethodDbId) throws BrAPIServerException {
		return getBreedingMethodEntity(breedingMethodDbId, HttpStatus.BAD_REQUEST);
	}

	public BreedingMethodEntity getBreedingMethodEntity(String breedingMethodDbId, HttpStatus errorStatus) throws BrAPIServerException {
		BreedingMethodEntity breedingMethodEntity = null;
		Optional<BreedingMethodEntity> entityOpt = breedingMethodRepository.findById(UUID.fromString(breedingMethodDbId));
		if (entityOpt.isPresent()) {
			breedingMethodEntity = entityOpt.get();
		} else {
			throw new BrAPIServerDbIdNotFoundException("breedingMethod", breedingMethodDbId, errorStatus);
		}
		return breedingMethodEntity;
	}

	private BreedingMethod convertFromEntity(BreedingMethodEntity entity) {
		BreedingMethod method = new BreedingMethod();
		method.setAbbreviation(entity.getAbbreviation());
		method.setBreedingMethodDbId(entity.getId().toString());
		method.setBreedingMethodName(entity.getName());
		method.setDescription(entity.getDescription());
		return method;
	}

}
