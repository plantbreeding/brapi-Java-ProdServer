package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public abstract class BrAPIDataModel {

	@JsonProperty("additionalInfo")
	protected Map<String, Object> additionalInfo = null;

	@JsonProperty("externalReferences")
	protected ExternalReferences externalReferences = null;

	final public BrAPIDataModel additionalInfo(Map<String, Object>additionalInfo) {
		this.additionalInfo = additionalInfo;
		return this;
	}

	final public Map<String, Object>getAdditionalInfo() {
		return additionalInfo;
	}

	final public void setAdditionalInfo(Map<String, Object>additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	

	final public BrAPIDataModel externalReferences(ExternalReferences externalReferences) {
		this.externalReferences = externalReferences;
		return this;
	}

	final public ExternalReferences getExternalReferences() {
		return externalReferences;
	}

	final public void setExternalReferences(ExternalReferences externalReferences) {
		this.externalReferences = externalReferences;
	}
}
