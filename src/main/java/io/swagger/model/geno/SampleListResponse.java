package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.BrAPIResponse;
import io.swagger.model.Context;
import io.swagger.model.Metadata;

import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;


/**
 * SampleListResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
public class SampleListResponse implements BrAPIResponse<SampleListResponseResult>  {
  @JsonProperty("@context")
  private Context _atContext = null;

  @JsonProperty("metadata")
  private Metadata metadata = null;

  @JsonProperty("result")
  private SampleListResponseResult result = null;

  public SampleListResponse _atContext(Context _atContext) {
    this._atContext = _atContext;
    return this;
  }

  

  public void set_atContext(Context _atContext) {
    this._atContext = _atContext;
  }

  public SampleListResponse metadata(Metadata metadata) {
    this.metadata = metadata;
    return this;
  }

  /**
   * Get metadata
   * @return metadata
  **/
  @ApiModelProperty(required = true, value = "")
      

    @Valid
    public Metadata getMetadata() {
    return metadata;
  }

  public void setMetadata(Metadata metadata) {
    this.metadata = metadata;
  }

  public SampleListResponse result(SampleListResponseResult result) {
    this.result = result;
    return this;
  }

  /**
   * Get result
   * @return result
  **/
  @ApiModelProperty(required = true, value = "")
      

    @Valid
    public SampleListResponseResult getResult() {
    return result;
  }

  public void setResult(SampleListResponseResult result) {
    this.result = result;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SampleListResponse sampleListResponse = (SampleListResponse) o;
    return Objects.equals(this._atContext, sampleListResponse._atContext) &&
        Objects.equals(this.metadata, sampleListResponse.metadata) &&
        Objects.equals(this.result, sampleListResponse.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_atContext, metadata, result);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SampleListResponse {\n");
    
    sb.append("    _atContext: ").append(toIndentedString(_atContext)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
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
