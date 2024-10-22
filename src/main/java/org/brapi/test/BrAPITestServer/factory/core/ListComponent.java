package org.brapi.test.BrAPITestServer.factory.core;

import io.swagger.model.Metadata;
import io.swagger.model.SearchRequest;
import io.swagger.model.core.BatchSearchRequest;
import io.swagger.model.core.BatchTypes;
import io.swagger.model.core.ListSearchRequest;
import io.swagger.model.core.ListSummary;
import jakarta.validation.Valid;
import org.brapi.test.BrAPITestServer.factory.BrAPIComponent;
import org.brapi.test.BrAPITestServer.service.core.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListComponent implements BrAPIComponent<ListSummary, ListSearchRequest> {
    private final ListService listService;

    @Autowired
    public ListComponent(ListService listService) {
        this.listService = listService;
    }

    @Override
    public List<ListSummary> findEntities(@Valid ListSearchRequest request, Metadata metadata) {
        return listService.findLists(request, metadata);
    }

    @Override
    public BatchTypes getType() {
        return BatchTypes.LISTS;
    }
}