package org.brapi.test.BrAPITestServer.factory.germ;

import io.swagger.model.Metadata;
import io.swagger.model.core.BatchTypes;
import io.swagger.model.germ.Germplasm;
import io.swagger.model.germ.GermplasmSearchRequest;
import jakarta.validation.Valid;
import org.brapi.test.BrAPITestServer.factory.BrAPIComponent;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity;
import org.brapi.test.BrAPITestServer.service.germ.GermplasmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    @Override
    public void deleteBatchData(List<String> dbIds) {

    }

    @Override
    public void softDeleteBatchData(List<String> dbIds) {

    }
}