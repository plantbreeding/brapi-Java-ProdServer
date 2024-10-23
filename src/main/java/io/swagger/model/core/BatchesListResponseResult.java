package io.swagger.model.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.BrAPIResponseResult;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * BatchesBatchResponseResult
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class BatchesListResponseResult<T> implements BrAPIResponseResult<T>  {

  @JsonProperty("batchDbId")
  @Valid
  private String batchDbId = null;

  @JsonProperty("data")
  @Valid
  private List<T> data = new ArrayList<>();

  public BatchesListResponseResult<T> batchDbId(String batchDbId) {
      this.batchDbId = batchDbId;
      return this;
  }
  public BatchesListResponseResult<T> data(List<T> data) {
    this.data = data;
    return this;
  }

  public BatchesListResponseResult addDataItem(T dataItem) {
    this.data.add(dataItem);
    return this;
  }

  /**
   * Get data
   * @return data
  **/
  @ApiModelProperty(required = true, value = "")
      
    @Valid
    public List<T> getData() {
    return data;
  }

  public void setData(List<T> data) {
    this.data = data;
  }

  public String getBatchDbId() { return batchDbId; }

  public void setBatchDbId(String batchDbId) { this.batchDbId = batchDbId; }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BatchesListResponseResult BatchesListResponseResult = (BatchesListResponseResult) o;
    return Objects.equals(this.data, BatchesListResponseResult.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BatchesBatchResponseResult {\n");
    
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
