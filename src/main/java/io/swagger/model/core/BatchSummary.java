package io.swagger.model.core;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * BatchSummary
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class BatchSummary extends BatchBaseFields  {
  @JsonProperty("batchDbId")
  private String batchDbId = null;

  public BatchSummary batchDbId(String batchDbId) {
    this.batchDbId = batchDbId;
    return this;
  }

  /**
   * The unique identifier for a Batch
   * @return batchDbId
  **/
  @ApiModelProperty(example = "6f621cfa", required = true, value = "The unique identifier for a Batch")
      

    public String getBatchDbId() {
    return batchDbId;
  }

  public void setBatchDbId(String batchDbId) {
    this.batchDbId = batchDbId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BatchSummary batchSummary = (BatchSummary) o;
    return Objects.equals(this.batchDbId, batchSummary.batchDbId) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(batchDbId, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BatchSummary {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    batchDbId: ").append(toIndentedString(batchDbId)).append("\n");
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