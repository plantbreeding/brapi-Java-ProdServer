package org.brapi.test.BrAPITestServer.controller.core;

import io.swagger.model.BrAPIResponse;
import io.swagger.model.Metadata;
import io.swagger.model.core.*;
import io.swagger.api.core.ListsApi;

import org.apache.http.HttpResponse;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerDbIdNotFoundException;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.factory.BrAPIComponent;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity.SearchRequestTypes;
import org.brapi.test.BrAPITestServer.service.SearchService;
import org.brapi.test.BrAPITestServer.service.core.ListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
@Controller
public class ListsApiController extends BrAPIController implements ListsApi {

	private static final Logger log = LoggerFactory.getLogger(ListsApiController.class);

	private final HttpServletRequest request;
	private final ListService listService;
	private final SearchService searchService;

	@Autowired
	public ListsApiController(ListService listService, SearchService searchService, HttpServletRequest request) {
		this.listService = listService;
		this.searchService = searchService;
		this.request = request;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ListsListResponse> listsGet(
			@Valid @RequestParam(value = "batchDeleteDbId", required = false) String batchDeleteDbId,
			@Valid @RequestParam(value = "listType", required = false) String listType,
			@Valid @RequestParam(value = "listName", required = false) String listName,
			@Valid @RequestParam(value = "listDbId", required = false) String listDbId,
			@Valid @RequestParam(value = "listSource", required = false) String listSource,
			@Valid @RequestParam(value = "programDbId", required = false) String programDbId,
			@Valid @RequestParam(value = "commonCropName", required = false) String commonCropName,
			@Valid @RequestParam(value = "externalReferenceId", required = false) String externalReferenceId,
			@Valid @RequestParam(value = "externalReferenceID", required = false) String externalReferenceID,
			@Valid @RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);

		// If a batch delete dbId is given then get the referenced lists, ignoring all other query params except pagination
		if (batchDeleteDbId != null) {
			List<ListSummary> batchDeleteData = listService.findBatchDeleteLists(batchDeleteDbId, metadata);
			return responseOK(new ListsListResponse(), new ListsListResponseResult(), batchDeleteData, metadata);
		}

		List<ListSummary> data = listService.findLists(ListTypes.fromValue(listType), listName, listDbId, listSource, programDbId, commonCropName, externalReferenceId, externalReferenceID, externalReferenceSource, metadata);
		return responseOK(new ListsListResponse(), new ListsListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ListsSingleResponse> listsListDbIdGet(
			@PathVariable("listDbId") String listDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		ListDetails data = listService.getList(listDbId);
		return responseOK(new ListsSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ListResponse> listsListDbIdItemsPost(
			@PathVariable("listDbId") String listDbId,
			@Valid @RequestBody ArrayList<String> body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		return listsListDbIdDataPost(listDbId, body, authorization);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ListResponse> listsListDbIdDataPost(
			@PathVariable("listDbId") String listDbId,
			@Valid @RequestBody ArrayList<String> body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		ListDetails data = listService.updateListItems(listDbId, body);
		return responseOK(new ListResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ListsSingleResponse> listsListDbIdPut(
			@PathVariable("listDbId") String listDbId,
			@Valid @RequestBody ListNewRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		ListDetails data = listService.updateList(listDbId, body);
		return responseOK(new ListsSingleResponse(), data);
	}
    @CrossOrigin
	@Override
	public ResponseEntity<ListsSingleResponse> listsListDbIdDelete(
			@PathVariable("listDbId") String listDbId,
			@Valid @RequestParam(value = "hardDelete", defaultValue = "false" ,required = false) boolean hardDelete,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

			log.debug("Request: " + request.getRequestURI());
			validateSecurityContext(request, "ROLE_USER");
			validateAcceptHeader(request);

			if (hardDelete) {
				listService.deleteList(listDbId);
				return responseNoContent();
			}

			listService.softDeleteList(listDbId);
			return responseNoContent();
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ListsListResponse> listsPost(@Valid @RequestBody List<ListNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		List<ListSummary> data = listService.saveNewList(body);
		return responseOK(new ListsListResponse(), new ListsListResponseResult(), data);
	}
	
	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchListsPost(
			@Valid @RequestBody ListSearchRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(body);

		String searchReqDbId = searchService.saveSearchRequest(body, SearchRequestTypes.LISTS);
		if (searchReqDbId != null) {
			return responseAccepted(searchReqDbId);
		} else {
			List<ListSummary> data = listService.findLists(body, metadata);
			return responseOK(new ListsListResponse(), new ListsListResponseResult(), data, metadata);
		}
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchListsSearchResultsDbIdGet(
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
			ListSearchRequest body = request.getParameters(ListSearchRequest.class);
			List<ListSummary> data = listService.findLists(body, metadata);
			return responseOK(new ListsListResponse(), new ListsListResponseResult(), data, metadata);
		}else {
			return responseAccepted(searchResultsDbId);
		}
	}

}
