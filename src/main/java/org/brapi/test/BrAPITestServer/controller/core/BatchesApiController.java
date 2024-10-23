package org.brapi.test.BrAPITestServer.controller.core;

import io.swagger.model.BrAPIResponse;
import io.swagger.model.Metadata;
import io.swagger.model.SearchRequest;
import io.swagger.model.core.*;
import io.swagger.api.core.BatchesApi;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.factory.BrAPIComponent;
import org.brapi.test.BrAPITestServer.factory.BrAPIComponentFactory;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity;
import org.brapi.test.BrAPITestServer.service.SearchService;
import org.brapi.test.BrAPITestServer.service.core.BatchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;
import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
@Controller
public class BatchesApiController extends BrAPIController implements BatchesApi {

	private static final Logger log = LoggerFactory.getLogger(BatchesApiController.class);

	private final HttpServletRequest request;
	private final BatchService batchService;
	private final SearchService searchService;
	private final BrAPIComponentFactory componentFactory;

	@Autowired
	public BatchesApiController(BatchService batchService, SearchService searchService, BrAPIComponentFactory componentFactory, HttpServletRequest request) {
		this.batchService = batchService;
		this.searchService = searchService;
		this.componentFactory = componentFactory;
		this.request = request;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<BatchesSingleResponse> batchesBatchDbIdGet(
			@PathVariable("batchDbId") String batchDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		BatchDetails data = batchService.getBatch(batchDbId);
		return responseOK(new BatchesSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<BatchResponse> batchesBatchDbIdItemsPost(
			@PathVariable("batchDbId") String batchDbId,
			@Valid @RequestBody ArrayList<String> body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		return batchesBatchDbIdDataPost(batchDbId, body, authorization);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<BatchResponse> batchesBatchDbIdDataPost(
			@PathVariable("batchDbId") String batchDbId,
			@Valid @RequestBody ArrayList<String> body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		BatchDetails data = batchService.updateBatchItems(batchDbId, body);
		return responseOK(new BatchResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<BatchesSingleResponse> batchesBatchDbIdPut(
			@PathVariable("batchDbId") String batchDbId,
			@Valid @RequestBody BatchNewRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		BatchDetails data = batchService.updateBatch(batchDbId, body);
		return responseOK(new BatchesSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> batchesPost(@Valid @RequestBody BatchSearchRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(body);
		
		// Fetch requested BrAPI entities
		BatchTypes batchType = body.getBatchType();
		BrAPIComponent component = componentFactory.getComponent(batchType);
		SearchRequest entitySearch = body.getSearchRequest();
		List<?> entities = component.findEntities(entitySearch, metadata);

		// Create a new batch for the requested entites
		List<String> entityDbIds = component.collectDbIds(entities);
		BatchNewRequest newBatchRequest = new BatchNewRequest().data(entityDbIds);
		String newBatchDbID = batchService.saveNewBatch(Arrays.asList(newBatchRequest)).get(0).getBatchDbId();

		return responseOK(newBatchDbID, entities, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchBatchesSearchResultsDbIdGet(
			@PathVariable("searchResultsDbId") String searchResultsDbId,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		SearchRequestEntity request = searchService.findById(searchResultsDbId);
		if (request != null) {
			BatchSearchRequest body = request.getParameters(BatchSearchRequest.class);
			BatchTypes batchType = body.getBatchType();
			BrAPIComponent component = componentFactory.getComponent(batchType);
			List<BatchSummary> data = component.findEntities(body, metadata);
			List<String> dbIds = data.stream().map(BatchSummary::getBatchDbId).collect(Collectors.toList());
			BatchNewRequest newBatchRequest = new BatchNewRequest();
			newBatchRequest.data(dbIds);
			batchService.saveNewBatch(Arrays.asList(newBatchRequest));
			return responseOK(new BatchesListResponse(), new BatchesListResponseResult(), data, metadata);
		}else {
			return responseAccepted(searchResultsDbId);
		}
	}

	@CrossOrigin
	public ResponseEntity<BatchesSingleResponse> batchesBatchDbIdDelete(
			@PathVariable("batchDbId") String batchDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		batchService.deleteBatch(batchDbId);
		return responseOK(new BatchesSingleResponse(), null);
	}
}