package org.brapi.test.BrAPITestServer.model.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.LongVarcharJdbcType;
import org.springframework.http.HttpStatus;

import java.io.IOException;

@Entity
@Table(name = "search")
public class SearchRequestEntity extends BrAPIPrimaryEntity {
    @Column
    private SearchRequestTypes requestType;
    @Column
    private Integer responseCountdown;
    @JdbcType(LongVarcharJdbcType.class)
    private String parameters;

    public SearchRequestTypes getRequestType() {
        return requestType;
    }

    public void setRequestType(SearchRequestTypes requestType) {
        this.requestType = requestType;
    }

    public Integer getResponseCountdown() {
        return responseCountdown;
    }

    public void setResponseCountdown(Integer responseCountdown) {
        this.responseCountdown = responseCountdown;
    }

    public String getParametersStr() {
        return parameters;
    }

    public <T> T getParameters(Class<T> clazz) throws BrAPIServerException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(parameters, clazz);
        } catch (IOException e) {
            throw new BrAPIServerException(HttpStatus.BAD_REQUEST, "Could not de-serialize search request. Please POST request again.");
        }
    }

    public void setParameters(Object parameters) throws BrAPIServerException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            this.parameters = mapper.writeValueAsString(parameters);
        } catch (JsonProcessingException e) {
            throw new BrAPIServerException(HttpStatus.BAD_REQUEST, "Could not serialize request. Please POST request again.");
        }
    }

	public enum SearchRequestTypes {CALLS, CALLSETS, MARKER_POSITIONS, REFERENCES, REFERENCESETS, VARIANTS, VARIANTSETS, GERMPLASM, GERMPLASM_ATTRIBUTES, GERMPLASM_ATTRIBUTE_VALUES, IMAGES, LISTS, LOCATIONS, MARKERS, OBSERVATIONS, OBSERVATION_TABLES, OBSERVATION_UNITS, PEOPLE, PEDIGREE, PROGRAMS, SAMPLES, STUDIES, TRIALS, VARIABLES, BATCHES};

}
