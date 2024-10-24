package org.brapi.test.BrAPITestServer.factory.germ;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.Metadata;
import io.swagger.model.SearchRequest;
import io.swagger.model.core.BatchSearchRequest;
import io.swagger.model.core.BatchTypes;
import io.swagger.model.germ.Germplasm;
import io.swagger.model.germ.GermplasmSearchRequest;
import jakarta.validation.Valid;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.factory.BrAPIComponent;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity;
import org.brapi.test.BrAPITestServer.service.germ.GermplasmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GermplasmComponent implements BrAPIComponent<Germplasm, GermplasmSearchRequest> {
    private final GermplasmService germplasmService;

    @Autowired
    public GermplasmComponent(GermplasmService germplasmService) {
        this.germplasmService = germplasmService;
    }

    @Override
    public List<Germplasm> findEntities(@Valid GermplasmSearchRequest request, Metadata metadata) {
        return germplasmService.findGermplasm(request, metadata);
    }

    @Override
    public BatchTypes getBatchType() {
        return BatchTypes.GERMPLASM;
    }

    @Override
    public SearchRequestEntity.SearchRequestTypes getSearchType() {
        return SearchRequestEntity.SearchRequestTypes.GERMPLASM;
    }

    @Override
    public List<String> collectDbIds(List<Germplasm> entities) {
        return entities.stream().map(Germplasm::getGermplasmDbId).collect(Collectors.toList());
    }
}