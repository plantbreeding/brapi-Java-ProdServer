package org.brapi.test.BrAPITestServer.factory.germ;

import io.swagger.model.Metadata;
import io.swagger.model.SearchRequest;
import io.swagger.model.core.BatchTypes;
import io.swagger.model.germ.Germplasm;
import io.swagger.model.germ.GermplasmSearchRequest;
import jakarta.validation.Valid;
import org.brapi.test.BrAPITestServer.factory.BrAPIComponent;
import org.brapi.test.BrAPITestServer.service.germ.GermplasmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
    public BatchTypes getType() {
        return BatchTypes.GERMPLASM;
    }
}