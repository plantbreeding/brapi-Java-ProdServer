package org.brapi.test.BrAPITestServer.factory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.BrAPIResponse;
import io.swagger.model.BrAPIResponseResult;
import io.swagger.model.Metadata;
import io.swagger.model.SearchRequest;
import io.swagger.model.core.BatchSearchRequest;
import io.swagger.model.core.BatchTypes;
import io.swagger.model.core.BatchesListResponse;
import io.swagger.model.core.BatchesListResponseResult;
import io.swagger.model.germ.GermplasmSearchRequest;
import jakarta.validation.Valid;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BrAPIComponent<T, R extends SearchRequest> {
    List<T> findEntities(@Valid R request, Metadata metadata);
    BatchTypes getType();
    List<String> collectDbIds(List<T> entities);
}