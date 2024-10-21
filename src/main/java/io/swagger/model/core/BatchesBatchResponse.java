package io.swagger.model.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.BrAPIResponse;
import io.swagger.model.Context;
import io.swagger.model.Metadata;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * BatchessBatchResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class BatchesBatchResponse implements BrAPIResponse<BatchesBatchResponseResult> {
	@JsonProperty("@context")
	private Context _atContext = null;

	@JsonProperty("metadata")
	private Metadata metadata = null;

	@JsonProperty("result")
	private BatchesBatchResponseResult result = null;

	public BatchesBatchResponse() {
		this._atContext = new Context();
		this._atContext.add("context");
	}
	

	public void set_atContext(Context _atContext) {
		this._atContext = _atContext;
	}
	public BatchesBatchResponse metadata(Metadata metadata) {
		this.metadata = metadata;
		return this;
	}

	/**
	 * Get metadata
	 * 
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

	public BatchesBatchResponse result(BatchesBatchResponseResult result) {
		this.result = result;
		return this;
	}

	/**
	 * Get result
	 * 
	 * @return result
	 **/
	@ApiModelProperty(required = true, value = "")
	

	@Valid
	public BatchesBatchResponseResult getResult() {
		return result;
	}

	public void setResult(BatchesBatchResponseResult result) {
		this.result = result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		BatchesBatchResponse BatchesBatchResponse = (io.swagger.model.core.BatchesBatchResponse) o;
		return Objects.equals(this._atContext, BatchesBatchResponse._atContext)
				&& Objects.equals(this.metadata, BatchesBatchResponse.metadata)
				&& Objects.equals(this.result, BatchesBatchResponse.result);
	}

	@Override
	public int hashCode() {
		return Objects.hash(_atContext, metadata, result);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class BatchesBatchResponse {\n");

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
	private String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
