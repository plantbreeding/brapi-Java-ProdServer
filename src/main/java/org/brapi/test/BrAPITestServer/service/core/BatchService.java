package org.brapi.test.BrAPITestServer.service.core;

import java.util.*;
import java.util.stream.Collectors;

import jakarta.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerDbIdNotFoundException;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.core.BatchEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.BatchItemEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.PersonEntity;
import org.brapi.test.BrAPITestServer.repository.core.BatchRepository;
import org.brapi.test.BrAPITestServer.service.DateUtility;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.core.BatchBaseFieldsInterface;
import io.swagger.model.core.BatchDetails;
import io.swagger.model.core.BatchNewRequest;
import io.swagger.model.core.BatchSummary;
import io.swagger.model.core.BatchTypes;

@Service
public class BatchService {

	private BatchRepository batchRepository;
	private PeopleService peopleService;

	public BatchService(BatchRepository batchRepository, PeopleService peopleService) {
		this.batchRepository = batchRepository;
		this.peopleService = peopleService;
	}

	public BatchDetails getBatch(String batchDbId) throws BrAPIServerException {
		BatchEntity entity;

		Optional<BatchEntity> entityOpt = batchRepository.findById(batchDbId);
		if (entityOpt.isPresent()) {
			entity = entityOpt.get();
		} else {
			throw new BrAPIServerDbIdNotFoundException("batch", batchDbId, HttpStatus.NOT_FOUND);
		}

		return convertToDetails(entity);
	}

	public BatchDetails updateBatchItems(String batchDbId, List<String> batchItems) throws BrAPIServerException {
		BatchEntity savedEntity;
		Optional<BatchEntity> entityOpt = batchRepository.findById(batchDbId);
		if (entityOpt.isPresent()) {
			BatchEntity entity = entityOpt.get();
			entity.setDateModified(new Date());

			List<BatchItemEntity> itemEntities = batchItems.stream().map((item) -> {
				BatchItemEntity itemEntity = new BatchItemEntity();
				itemEntity.setItem(item);
				itemEntity.setBatch(entity);
				return itemEntity;
			}).collect(Collectors.toList());

			entity.getData().addAll(itemEntities);

			savedEntity = batchRepository.save(entity);
		} else {
			throw new BrAPIServerDbIdNotFoundException("batch", batchDbId, HttpStatus.NOT_FOUND);
		}

		return convertToDetails(savedEntity);
	}

	public BatchDetails updateBatch(String batchDbId, BatchNewRequest batch) throws BrAPIServerException {
		BatchEntity savedEntity;
		Optional<BatchEntity> entityOpt = batchRepository.findById(batchDbId);
		if (entityOpt.isPresent()) {
			BatchEntity entity = entityOpt.get();
			updateEntity(entity, batch);
			entity.setDateModified(new Date());

			savedEntity = batchRepository.save(entity);
		} else {
			throw new BrAPIServerDbIdNotFoundException("batch", batchDbId, HttpStatus.NOT_FOUND);
		}

		return convertToDetails(savedEntity);
	}

	public List<BatchSummary> saveNewBatch(@Valid List<BatchNewRequest> requests) throws BrAPIServerException {

		List<BatchSummary> savedBatches = new ArrayList<>();

		for (BatchNewRequest batch : requests) {

			BatchEntity entity = new BatchEntity();
			updateEntity(entity, batch);
			Date now = new Date();
			entity.setDateCreated(now);
			entity.setDateModified(now);

			BatchEntity savedEntity = batchRepository.save(entity);

			savedBatches.add(convertToSummary(savedEntity));
		}

		return savedBatches;
	}

	public void deleteBatch(String batchDbId) throws BrAPIServerException {
		BatchDetails batch = getBatch(batchDbId);
		batchRepository.deleteAllByIdInBatch(batch.getData());
	}

	private BatchDetails convertToDetails(BatchEntity entity) {
		BatchDetails details = new BatchDetails();
		details = (BatchDetails) convertToBaseFields(entity, details);
		details.setBatchDbId(entity.getId());
		details.setData(entity.getData().stream().map((e) -> {
			return e.getItem();
		}).collect(Collectors.toList()));

		return details;
	}

	private BatchSummary convertToSummary(BatchEntity entity) {
		BatchSummary summary = new BatchSummary();
		summary = (BatchSummary) convertToBaseFields(entity, summary);
		summary.setBatchDbId(entity.getId());

		return summary;
	}

	private BatchBaseFieldsInterface convertToBaseFields(BatchEntity entity, BatchBaseFieldsInterface base) {
		base.setDateCreated(DateUtility.toOffsetDateTime(entity.getDateCreated()));
		base.setDateModified(DateUtility.toOffsetDateTime(entity.getDateModified()));
		base.setBatchDescription(entity.getDescription());
		base.setBatchName(entity.getBatchName());
		base.setBatchOwnerName(entity.getBatchOwnerName());
		base.setBatchSource(entity.getBatchSource());
		base.setBatchType(entity.getBatchType());
		base.setAdditionalInfo(entity.getAdditionalInfo());
		base.setExternalReferences(entity.getExternalReferencesMap());

		if (entity.getBatchOwnerPerson() != null) {
			base.setBatchOwnerPersonDbId(entity.getBatchOwnerPerson().getId());
		}
		if (entity.getData() != null) {
			base.setBatchSize(entity.getData().size());
		}
		return base;
	}

	private void updateEntity(BatchEntity entity, @Valid BatchNewRequest batch) throws BrAPIServerException {

		if (batch.getAdditionalInfo() != null)
			entity.setAdditionalInfo(batch.getAdditionalInfo());
		if (batch.getBatchDescription() != null)
			entity.setDescription(batch.getBatchDescription());
		if (batch.getExternalReferences() != null)
			entity.setExternalReferences(batch.getExternalReferences());
		if (batch.getBatchName() != null)
			entity.setBatchName(batch.getBatchName());
		if (batch.getBatchOwnerName() != null)
			entity.setBatchOwnerName(batch.getBatchOwnerName());
		if (batch.getBatchSource() != null)
			entity.setBatchSource(batch.getBatchSource());
		if (batch.getBatchType() != null)
			entity.setBatchType(batch.getBatchType());

		if (batch.getBatchOwnerPersonDbId() != null) {
			PersonEntity person = peopleService.getPersonEntity(batch.getBatchOwnerPersonDbId());
			entity.setBatchOwnerPerson(person);
		}

		if (entity.getData() != null) {
			entity.getData().stream().forEach((item) -> {
				item.setBatch(null);
			});
		}

		if (batch.getData() != null) {
			List<BatchItemEntity> items = new ArrayList<>();
			ListIterator<String> iter = batch.getData().listIterator();
			while (iter.hasNext()) {
				String item = iter.next();
				if (item != null) {
					BatchItemEntity itemEntity = new BatchItemEntity();
					itemEntity.setItem(item);
					itemEntity.setBatch(entity);
					items.add(itemEntity);
				}
			}
			entity.setData(items);
		} else {
			entity.setData(new ArrayList<>());
		}
	}
}