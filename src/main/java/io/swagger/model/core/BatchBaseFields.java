package io.swagger.model.core;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.ExternalReferences;

import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

/**
 * BatchBaseFields
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class BatchBaseFields implements BatchBaseFieldsInterface  {
  @JsonProperty("additionalInfo")
  @Valid
  private Object additionalInfo = null;

  @JsonProperty("dateCreated")
  private OffsetDateTime dateCreated = null;

  @JsonProperty("dateModified")
  private OffsetDateTime dateModified = null;

  @JsonProperty("externalReferences")
  private ExternalReferences externalReferences = null;

  @JsonProperty("batchDescription")
  private String batchDescription = null;

  @JsonProperty("batchName")
  private String batchName = null;

  @JsonProperty("batchOwnerName")
  private String batchOwnerName = null;

  @JsonProperty("batchOwnerPersonDbId")
  private String batchOwnerPersonDbId = null;

  @JsonProperty("batchSize")
  private Integer batchSize = null;

  @JsonProperty("batchSource")
  private String batchSource = null;

  @JsonProperty("batchType")
  private BatchTypes batchType = null;

  public BatchBaseFields additionalInfo(Object additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  /**
   * Additional arbitrary info
   *
   * @return additionalInfo
   **/
  @ApiModelProperty(example = "{}", value = "Additional arbitrary info")
  
    public Object getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(Object additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  public BatchBaseFields dateCreated(OffsetDateTime dateCreated) {
    this.dateCreated = dateCreated;
    return this;
  }

  /**
   * Timestamp when the entity was first created
   * @return dateCreated
  **/
  @ApiModelProperty(value = "Timestamp when the entity was first created")
  
    @Valid
    public OffsetDateTime getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(OffsetDateTime dateCreated) {
    this.dateCreated = dateCreated;
  }

  public BatchBaseFields dateModified(OffsetDateTime dateModified) {
    this.dateModified = dateModified;
    return this;
  }

  /**
   * Timestamp when the entity was last updated
   * @return dateModified
  **/
  @ApiModelProperty(value = "Timestamp when the entity was last updated")
  
    @Valid
    public OffsetDateTime getDateModified() {
    return dateModified;
  }

  public void setDateModified(OffsetDateTime dateModified) {
    this.dateModified = dateModified;
  }

  public BatchBaseFields externalReferences(ExternalReferences externalReferences) {
    this.externalReferences = externalReferences;
    return this;
  }

  /**
   * Get externalReferences
   * @return externalReferences
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public ExternalReferences getExternalReferences() {
    return externalReferences;
  }

  public void setExternalReferences(ExternalReferences externalReferences) {
    this.externalReferences = externalReferences;
  }

  public BatchBaseFields batchDescription(String batchDescription) {
    this.batchDescription = batchDescription;
    return this;
  }

  /**
   * Description of a Batch
   * @return batchDescription
  **/
  @ApiModelProperty(example = "This is a batch of germplasm I would like to investigate next season", value = "Description of a Batch")
  
    public String getBatchDescription() {
    return batchDescription;
  }

  public void setBatchDescription(String batchDescription) {
    this.batchDescription = batchDescription;
  }

  public BatchBaseFields batchName(String batchName) {
    this.batchName = batchName;
    return this;
  }

  /**
   * Human readable name of a Batch
   * @return batchName
  **/
  @ApiModelProperty(example = "MyGermplasm_Sept_2020", value = "Human readable name of a Batch")
  
    public String getBatchName() {
    return batchName;
  }

  public void setBatchName(String batchName) {
    this.batchName = batchName;
  }

  public BatchBaseFields batchOwnerName(String batchOwnerName) {
    this.batchOwnerName = batchOwnerName;
    return this;
  }

  /**
   * Human readable name of a Batch Owner. (usually a user or person)
   * @return batchOwnerName
  **/
  @ApiModelProperty(example = "Bob Robertson", value = "Human readable name of a Batch Owner. (usually a user or person)")
  
    public String getBatchOwnerName() {
    return batchOwnerName;
  }

  public void setBatchOwnerName(String batchOwnerName) {
    this.batchOwnerName = batchOwnerName;
  }

  public BatchBaseFields batchOwnerPersonDbId(String batchOwnerPersonDbId) {
    this.batchOwnerPersonDbId = batchOwnerPersonDbId;
    return this;
  }

  /**
   * The unique identifier for a Batch Owner. (usually a user or person)
   * @return batchOwnerPersonDbId
  **/
  @ApiModelProperty(example = "58db0628", value = "The unique identifier for a Batch Owner. (usually a user or person)")
  
    public String getBatchOwnerPersonDbId() {
    return batchOwnerPersonDbId;
  }

  public void setBatchOwnerPersonDbId(String batchOwnerPersonDbId) {
    this.batchOwnerPersonDbId = batchOwnerPersonDbId;
  }

  public BatchBaseFields batchSize(Integer batchSize) {
    this.batchSize = batchSize;
    return this;
  }

  /**
   * The number of elements in a Batch
   * @return batchSize
  **/
  @ApiModelProperty(example = "53", value = "The number of elements in a Batch")
  
    public Integer getBatchSize() {
    return batchSize;
  }

  public void setBatchSize(Integer batchSize) {
    this.batchSize = batchSize;
  }

  public BatchBaseFields batchSource(String batchSource) {
    this.batchSource = batchSource;
    return this;
  }

  /**
   * The description of where a Batch originated from
   * @return batchSource
  **/
  @ApiModelProperty(example = "GeneBank Repository 1.3", value = "The description of where a Batch originated from")
  
    public String getBatchSource() {
    return batchSource;
  }

  public void setBatchSource(String batchSource) {
    this.batchSource = batchSource;
  }

  public BatchBaseFields batchType(BatchTypes batchType) {
    this.batchType = batchType;
    return this;
  }

  /**
   * Get batchType
   * @return batchType
  **/
  @ApiModelProperty(required = true, value = "")
      

    @Valid
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
    BatchBaseFields batchBaseFields = (BatchBaseFields) o;
    return Objects.equals(this.additionalInfo, batchBaseFields.additionalInfo) &&
        Objects.equals(this.dateCreated, batchBaseFields.dateCreated) &&
        Objects.equals(this.dateModified, batchBaseFields.dateModified) &&
        Objects.equals(this.externalReferences, batchBaseFields.externalReferences) &&
        Objects.equals(this.batchDescription, batchBaseFields.batchDescription) &&
        Objects.equals(this.batchName, batchBaseFields.batchName) &&
        Objects.equals(this.batchOwnerName, batchBaseFields.batchOwnerName) &&
        Objects.equals(this.batchOwnerPersonDbId, batchBaseFields.batchOwnerPersonDbId) &&
        Objects.equals(this.batchSize, batchBaseFields.batchSize) &&
        Objects.equals(this.batchSource, batchBaseFields.batchSource) &&
        Objects.equals(this.batchType, batchBaseFields.batchType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalInfo, dateCreated, dateModified, externalReferences, batchDescription, batchName, batchOwnerName, batchOwnerPersonDbId, batchSize, batchSource, batchType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BatchBaseFields {\n");
    
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    dateCreated: ").append(toIndentedString(dateCreated)).append("\n");
    sb.append("    dateModified: ").append(toIndentedString(dateModified)).append("\n");
    sb.append("    externalReferences: ").append(toIndentedString(externalReferences)).append("\n");
    sb.append("    batchDescription: ").append(toIndentedString(batchDescription)).append("\n");
    sb.append("    batchName: ").append(toIndentedString(batchName)).append("\n");
    sb.append("    batchOwnerName: ").append(toIndentedString(batchOwnerName)).append("\n");
    sb.append("    batchOwnerPersonDbId: ").append(toIndentedString(batchOwnerPersonDbId)).append("\n");
    sb.append("    batchSize: ").append(toIndentedString(batchSize)).append("\n");
    sb.append("    batchSource: ").append(toIndentedString(batchSource)).append("\n");
    sb.append("    batchType: ").append(toIndentedString(batchType)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}