package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.BrAPIResponseResult;
import io.swagger.model.pheno.ObservationVariable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;


/**
 * ObservationVariableListResponseResult
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:22.556Z[GMT]")
public class ObservationVariableListResponseResult implements BrAPIResponseResult<ObservationVariable>  {
  @JsonProperty("data")
  @Valid
  private List<ObservationVariable> data = new ArrayList<ObservationVariable>();

  public ObservationVariableListResponseResult data(List<ObservationVariable> data) {
    this.data = data;
    return this;
  }

  public ObservationVariableListResponseResult addDataItem(ObservationVariable dataItem) {
    this.data.add(dataItem);
    return this;
  }

  /**
   * Get data
   * @return data
  **/
  @ApiModelProperty(required = true, value = "")
      
    @Valid
    public List<ObservationVariable> getData() {
    return data;
  }

  public void setData(List<ObservationVariable> data) {
    this.data = data;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ObservationVariableListResponseResult observationVariableListResponseResult = (ObservationVariableListResponseResult) o;
    return Objects.equals(this.data, observationVariableListResponseResult.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObservationVariableListResponseResult {\n");
    
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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
