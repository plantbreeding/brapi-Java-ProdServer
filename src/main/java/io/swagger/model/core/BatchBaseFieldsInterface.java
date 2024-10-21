package io.swagger.model.core;

import java.time.OffsetDateTime;

import io.swagger.model.ExternalReferences;

public interface BatchBaseFieldsInterface {

	public BatchBaseFieldsInterface additionalInfo(Object additionalInfo);

	public Object getAdditionalInfo();

	public void setAdditionalInfo(Object additionalInfo);

	public BatchBaseFieldsInterface dateCreated(OffsetDateTime dateCreated);

	public OffsetDateTime getDateCreated();

	public void setDateCreated(OffsetDateTime dateCreated);

	public BatchBaseFieldsInterface dateModified(OffsetDateTime dateModified);

	public OffsetDateTime getDateModified();

	public void setDateModified(OffsetDateTime dateModified);

	public BatchBaseFieldsInterface externalReferences(ExternalReferences externalReferences);

	public ExternalReferences getExternalReferences();

	public void setExternalReferences(ExternalReferences externalReferences);

	public BatchBaseFieldsInterface batchDescription(String batchDescription);

	public String getBatchDescription();

	public void setBatchDescription(String batchDescription);

	public BatchBaseFieldsInterface batchName(String batchName);

	public String getBatchName();

	public void setBatchName(String batchName);

	public BatchBaseFieldsInterface batchOwnerName(String batchOwnerName);

	public String getBatchOwnerName();

	public void setBatchOwnerName(String batchOwnerName);

	public BatchBaseFieldsInterface batchOwnerPersonDbId(String batchOwnerPersonDbId);

	public String getBatchOwnerPersonDbId();

	public void setBatchOwnerPersonDbId(String batchOwnerPersonDbId);

	public BatchBaseFieldsInterface batchSize(Integer batchSize);

	public Integer getBatchSize();

	public void setBatchSize(Integer batchSize);

	public BatchBaseFieldsInterface batchSource(String batchSource);

	public String getBatchSource();

	public void setBatchSource(String batchSource);

	public BatchBaseFieldsInterface batchType(BatchTypes batchType);

	public BatchTypes getBatchType();

	public void setBatchType(BatchTypes batchType);

}