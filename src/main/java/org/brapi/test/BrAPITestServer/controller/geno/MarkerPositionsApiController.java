package org.brapi.test.BrAPITestServer.controller.geno;

import io.swagger.model.BrAPIResponse;
import io.swagger.model.Metadata;
import io.swagger.model.geno.MarkerPosition;
import io.swagger.model.geno.MarkerPositionsListResponse;
import io.swagger.model.geno.MarkerPositionsListResponseResult;
import io.swagger.model.geno.MarkerPositionSearchRequest;

import io.swagger.api.geno.MarkerPositionsApi;

import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity.SearchRequestTypes;
import org.brapi.test.BrAPITestServer.service.SearchService;
import org.brapi.test.BrAPITestServer.service.geno.MarkerPositionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

@javax.annotation.processing.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
@Controller
public class MarkerPositionsApiController extends BrAPIController implements MarkerPositionsApi {

	private static final Logger log = LoggerFactory.getLogger(MarkerPositionsApiController.class);

	private final MarkerPositionService markerPositionService;
	private final SearchService searchService;
	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public MarkerPositionsApiController(MarkerPositionService markerPositionService, SearchService searchService,
			HttpServletRequest request) {
		this.markerPositionService = markerPositionService;
		this.searchService = searchService;
		this.request = request;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<MarkerPositionsListResponse> markerpositionsGet(
			@RequestParam(value = "mapDbId", required = false) String mapDbId,
			@RequestParam(value = "linkageGroupName", required = false) String linkageGroupName,
			@RequestParam(value = "variantDbId", required = false) String variantDbId,
			@RequestParam(value = "minPosition", required = false) Integer minPosition,
			@RequestParam(value = "maxPosition", required = false) Integer maxPosition,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<MarkerPosition> data = markerPositionService.findMarkerPositions(mapDbId, linkageGroupName, variantDbId,
				maxPosition, minPosition, metadata);
		return responseOK(new MarkerPositionsListResponse(), new MarkerPositionsListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchMarkerpositionsPost(
			@RequestBody MarkerPositionSearchRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(body);

		String searchReqDbId = searchService.saveSearchRequest(body, SearchRequestTypes.MARKER_POSITIONS);
		if (searchReqDbId != null) {
			return responseAccepted(searchReqDbId);
		} else {
			List<MarkerPosition> data = markerPositionService.findMarkerPositions(body, metadata);
			return responseOK(new MarkerPositionsListResponse(), new MarkerPositionsListResponseResult(), data,
					metadata);
		}
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchMarkerpositionsSearchResultsDbIdGet(
			@PathVariable("searchResultsDbId") String searchResultsDbId,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		SearchRequestEntity request = searchService.findById(searchResultsDbId);
		if (request != null) {
			MarkerPositionSearchRequest body = request.getParameters(MarkerPositionSearchRequest.class);
			List<MarkerPosition> data = markerPositionService.findMarkerPositions(body, metadata);
			return responseOK(new MarkerPositionsListResponse(), new MarkerPositionsListResponseResult(), data,
					metadata);
		} else {
			return responseAccepted(searchResultsDbId);
		}
	}

}
