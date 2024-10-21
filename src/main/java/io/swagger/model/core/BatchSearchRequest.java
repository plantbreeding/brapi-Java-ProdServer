package io.swagger.model.core;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.model.SearchRequest;
import java.util.ArrayList;
import java.util.List;
import java.time.OffsetDateTime;

public class BatchSearchRequest extends SearchRequest {
	@JsonProperty("dateCreatedRangeEnd")
	private OffsetDateTime dateCreatedRangeEnd = null;

	@JsonProperty("dateCreatedRangeStart")
	private OffsetDateTime dateCreatedRangeStart = null;

	@JsonProperty("dateModifiedRangeEnd")
	private OffsetDateTime dateModifiedRangeEnd = null;

	@JsonProperty("dateModifiedRangeStart")
	private OffsetDateTime dateModifiedRangeStart = null;

	@JsonProperty("batchDbIds")
	private List<String> batchDbIds = null;

	@JsonProperty("batchNames")
	private List<String> batchNames = null;

	@JsonProperty("batchOwnerNames")
	private List<String> batchOwnerNames = null;

	@JsonProperty("batchOwnerPersonDbIds")
	private List<String> batchOwnerPersonDbIds = null;

	@JsonProperty("batchSources")
	private List<String> batchSources = null;

	@JsonProperty("programDbIds")
	private List<String> programDbIds = null;

	@JsonProperty("commonCropNames")
	private List<String> commonCropNames = null;

	@JsonProperty("batchType")
	private BatchTypes batchType = null;

	public BatchSearchRequest dateCreatedRangeEnd(OffsetDateTime dateCreatedRangeEnd) {
		this.dateCreatedRangeEnd = dateCreatedRangeEnd;
		return this;
	}

	public OffsetDateTime getDateCreatedRangeEnd() {
		return dateCreatedRangeEnd;
	}

	public void setDateCreatedRangeEnd(OffsetDateTime dateCreatedRangeEnd) {
		this.dateCreatedRangeEnd = dateCreatedRangeEnd;
	}

	public BatchSearchRequest dateCreatedRangeStart(OffsetDateTime dateCreatedRangeStart) {
		this.dateCreatedRangeStart = dateCreatedRangeStart;
		return this;
	}

	public OffsetDateTime getDateCreatedRangeStart() {
		return dateCreatedRangeStart;
	}

	public void setDateCreatedRangeStart(OffsetDateTime dateCreatedRangeStart) {
		this.dateCreatedRangeStart = dateCreatedRangeStart;
	}

	public BatchSearchRequest dateModifiedRangeEnd(OffsetDateTime dateModifiedRangeEnd) {
		this.dateModifiedRangeEnd = dateModifiedRangeEnd;
		return this;
	}

	public OffsetDateTime getDateModifiedRangeEnd() {
		return dateModifiedRangeEnd;
	}

	public void setDateModifiedRangeEnd(OffsetDateTime dateModifiedRangeEnd) {
		this.dateModifiedRangeEnd = dateModifiedRangeEnd;
	}

	public BatchSearchRequest dateModifiedRangeStart(OffsetDateTime dateModifiedRangeStart) {
		this.dateModifiedRangeStart = dateModifiedRangeStart;
		return this;
	}

	public OffsetDateTime getDateModifiedRangeStart() {
		return dateModifiedRangeStart;
	}

	public void setDateModifiedRangeStart(OffsetDateTime dateModifiedRangeStart) {
		this.dateModifiedRangeStart = dateModifiedRangeStart;
	}

	public BatchSearchRequest batchDbIds(List<String> batchDbIds) {
		this.batchDbIds = batchDbIds;
		return this;
	}

	public BatchSearchRequest addBatchDbIdsItem(String batchDbIdsItem) {
		if (this.batchDbIds == null) {
			this.batchDbIds = new ArrayList<String>();
		}
		this.batchDbIds.add(batchDbIdsItem);
		return this;
	}

	public List<String> getBatchDbIds() {
		return batchDbIds;
	}

	public void setBatchDbIds(List<String> batchDbIds) {
		this.batchDbIds = batchDbIds;
	}

	public BatchSearchRequest batchNames(List<String> batchNames) {
		this.batchNames = batchNames;
		return this;
	}

	public BatchSearchRequest addBatchNamesItem(String batchNamesItem) {
		if (this.batchNames == null) {
			this.batchNames = new ArrayList<String>();
		}
		this.batchNames.add(batchNamesItem);
		return this;
	}

	public List<String> getBatchNames() {
		return batchNames;
	}

	public void setBatchNames(List<String> batchNames) {
		this.batchNames = batchNames;
	}

	public BatchSearchRequest batchOwnerNames(List<String> batchOwnerNames) {
		this.batchOwnerNames = batchOwnerNames;
		return this;
	}

	public BatchSearchRequest addBatchOwnerNamesItem(String batchOwnerNamesItem) {
		if (this.batchOwnerNames == null) {
			this.batchOwnerNames = new ArrayList<String>();
		}
		this.batchOwnerNames.add(batchOwnerNamesItem);
		return this;
	}

	public List<String> getBatchOwnerNames() {
		return batchOwnerNames;
	}

	public void setBatchOwnerNames(List<String> batchOwnerNames) {
		this.batchOwnerNames = batchOwnerNames;
	}

	public BatchSearchRequest batchOwnerPersonDbIds(List<String> batchOwnerPersonDbIds) {
		this.batchOwnerPersonDbIds = batchOwnerPersonDbIds;
		return this;
	}

	public BatchSearchRequest addBatchOwnerPersonDbIdsItem(String batchOwnerPersonDbIdsItem) {
		if (this.batchOwnerPersonDbIds == null) {
			this.batchOwnerPersonDbIds = new ArrayList<String>();
		}
		this.batchOwnerPersonDbIds.add(batchOwnerPersonDbIdsItem);
		return this;
	}

	public List<String> getBatchOwnerPersonDbIds() {
		return batchOwnerPersonDbIds;
	}

	public void setBatchOwnerPersonDbIds(List<String> batchOwnerPersonDbIds) {
		this.batchOwnerPersonDbIds = batchOwnerPersonDbIds;
	}

	public BatchSearchRequest batchSources(List<String> batchSources) {
		this.batchSources = batchSources;
		return this;
	}

	public BatchSearchRequest addBatchSourcesItem(String batchSourcesItem) {
		if (this.batchSources == null) {
			this.batchSources = new ArrayList<String>();
		}
		this.batchSources.add(batchSourcesItem);
		return this;
	}

	public List<String> getBatchSources() {
		return batchSources;
	}

	public void setBatchSources(List<String> batchSources) {
		this.batchSources = batchSources;
	}

	public BatchSearchRequest programDbIds(List<String> programDbIds) {
		this.programDbIds = programDbIds;
		return this;
	}

	public BatchSearchRequest addprogramDbIdsItem(String programDbIdsItem) {
		if (this.programDbIds == null) {
			this.programDbIds = new ArrayList<String>();
		}
		this.programDbIds.add(programDbIdsItem);
		return this;
	}

	public List<String> getProgramDbIds() {
		return programDbIds;
	}

	public void setProgramDbIds(List<String> programDbIds) {
		this.programDbIds = programDbIds;
	}

	public BatchSearchRequest commonCropNames(List<String> commonCropNames) {
		this.commonCropNames = commonCropNames;
		return this;
	}

	public BatchSearchRequest addCommonCropNamesItem(String commonCropNamesItem) {
		if (this.commonCropNames == null) {
			this.commonCropNames = new ArrayList<String>();
		}
		this.commonCropNames.add(commonCropNamesItem);
		return this;
	}

	public List<String> getCommonCropNames() {
		return commonCropNames;
	}

	public void setCommonCropNames(List<String> commonCropNames) {
		this.commonCropNames = commonCropNames;
	}

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

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		BatchSearchRequest batchSearchRequest = (BatchSearchRequest) o;
		return Objects.equals(this.externalReferenceIds, batchSearchRequest.externalReferenceIds)
				&& Objects.equals(this.externalReferenceSources, batchSearchRequest.externalReferenceSources)
				&& Objects.equals(this.dateCreatedRangeEnd, batchSearchRequest.dateCreatedRangeEnd)
				&& Objects.equals(this.dateCreatedRangeStart, batchSearchRequest.dateCreatedRangeStart)
				&& Objects.equals(this.dateModifiedRangeEnd, batchSearchRequest.dateModifiedRangeEnd)
				&& Objects.equals(this.dateModifiedRangeStart, batchSearchRequest.dateModifiedRangeStart)
				&& Objects.equals(this.batchDbIds, batchSearchRequest.batchDbIds)
				&& Objects.equals(this.batchNames, batchSearchRequest.batchNames)
				&& Objects.equals(this.batchOwnerNames, batchSearchRequest.batchOwnerNames)
				&& Objects.equals(this.batchOwnerPersonDbIds, batchSearchRequest.batchOwnerPersonDbIds)
				&& Objects.equals(this.batchSources, batchSearchRequest.batchSources)
				&& Objects.equals(this.batchType, batchSearchRequest.batchType) && super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(externalReferenceIds, externalReferenceSources, dateCreatedRangeEnd, dateCreatedRangeStart,
				dateModifiedRangeEnd, dateModifiedRangeStart, batchDbIds, batchNames, batchOwnerNames,
				batchOwnerPersonDbIds, batchSources, batchType, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class BatchSearchRequest {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    externalReferenceIDs: ").append(toIndentedString(externalReferenceIds)).append("\n");
		sb.append("    externalReferenceSources: ").append(toIndentedString(externalReferenceSources)).append("\n");
		sb.append("    dateCreatedRangeEnd: ").append(toIndentedString(dateCreatedRangeEnd)).append("\n");
		sb.append("    dateCreatedRangeStart: ").append(toIndentedString(dateCreatedRangeStart)).append("\n");
		sb.append("    dateModifiedRangeEnd: ").append(toIndentedString(dateModifiedRangeEnd)).append("\n");
		sb.append("    dateModifiedRangeStart: ").append(toIndentedString(dateModifiedRangeStart)).append("\n");
		sb.append("    batchDbIds: ").append(toIndentedString(batchDbIds)).append("\n");
		sb.append("    batchNames: ").append(toIndentedString(batchNames)).append("\n");
		sb.append("    batchOwnerNames: ").append(toIndentedString(batchOwnerNames)).append("\n");
		sb.append("    batchOwnerPersonDbIds: ").append(toIndentedString(batchOwnerPersonDbIds)).append("\n");
		sb.append("    batchSources: ").append(toIndentedString(batchSources)).append("\n");
		sb.append("    batchType: ").append(toIndentedString(batchType)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

	@Override
	public Integer getTotalParameterCount() {
		Integer count = 0;
		if (this.externalReferenceIds != null) {
			count += this.externalReferenceIds.size();
		}
		if (this.externalReferenceSources != null) {
			count += this.externalReferenceSources.size();
		}
		if (this.dateCreatedRangeEnd != null) {
			count += 1;
		}
		if (this.dateCreatedRangeStart != null) {
			count += 1;
		}
		if (this.dateModifiedRangeEnd != null) {
			count += 1;
		}
		if (this.dateModifiedRangeStart != null) {
			count += 1;
		}
		if (this.batchDbIds != null) {
			count += this.batchDbIds.size();
		}
		if (this.batchNames != null) {
			count += this.batchNames.size();
		}
		if (this.batchOwnerNames != null) {
			count += this.batchOwnerNames.size();
		}
		if (this.batchOwnerPersonDbIds != null) {
			count += this.batchOwnerPersonDbIds.size();
		}
		if (this.batchSources != null) {
			count += this.batchSources.size();
		}
		if (this.batchType != null) {
			count += 1;
		}
		return count;
	}
}