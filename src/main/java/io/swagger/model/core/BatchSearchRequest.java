package io.swagger.model.core;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.model.SearchRequest;
import io.swagger.model.germ.GermplasmSearchRequest;

import java.util.ArrayList;
import java.util.List;
import java.time.OffsetDateTime;

public class BatchSearchRequest extends SearchRequest {
	@JsonProperty("batchType")
	private BatchTypes batchType = null;

	@JsonProperty("search")
	@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "batchType")
	@JsonSubTypes({
			@JsonSubTypes.Type(value = GermplasmSearchRequest.class, name = "germplasm"),
			@JsonSubTypes.Type(value = ListSearchRequest.class, name = "lists")
	})
	private SearchRequest searchRequest = null;

	public BatchSearchRequest batchType(BatchTypes batchType) {
		this.batchType = batchType;
		return this;
	}

	public BatchTypes getBatchType() {
		return batchType;
	}

	public void setBatchType(BatchTypes batchType) {
		this.batchType = batchType;
	}

	public SearchRequest getSearchRequest() {
		return searchRequest;
	}

	public void setSearchRequest(SearchRequest searchRequest) {
		this.searchRequest = searchRequest;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		return searchRequest.equals(o);
	}

	@Override
	public int hashCode() {
		return searchRequest.hashCode();
	}

	@Override
	public String toString() {
		return searchRequest.toString();
	}

	@Override
	public Integer getTotalParameterCount() {
		return searchRequest.getTotalParameterCount();
	}
}