package org.brapi.test.BrAPITestServer.controller.pheno;

import io.swagger.model.BrAPIResponse;
import io.swagger.model.Metadata;
import io.swagger.model.pheno.ObservationUnitListResponse;
import io.swagger.model.pheno.ObservationUnitNewRequest;
import io.swagger.model.pheno.ObservationUnitSearchRequest;
import io.swagger.model.pheno.ObservationUnitSingleResponse;
import io.swagger.model.pheno.ObservationUnitTable;
import io.swagger.model.pheno.ObservationUnitTableResponse;
import io.swagger.model.pheno.ObservationLevelListResponse;
import io.swagger.model.pheno.ObservationLevelListResponseResult;
import io.swagger.model.pheno.ObservationUnit;
import io.swagger.model.pheno.ObservationUnitHierarchyLevel;
import io.swagger.model.pheno.ObservationUnitListResponseResult;
import io.swagger.api.pheno.ObservationLevelsApi;
import io.swagger.api.pheno.ObservationUnitsApi;

import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity.SearchRequestTypes;
import org.brapi.test.BrAPITestServer.service.SearchService;
import org.brapi.test.BrAPITestServer.service.pheno.ObservationUnitService;
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
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Map;

@javax.annotation.processing.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:22.556Z[GMT]")
@Controller
public class ObservationUnitsApiController extends BrAPIController
		implements ObservationUnitsApi, ObservationLevelsApi {

	private static final Logger log = LoggerFactory.getLogger(ObservationUnitsApiController.class);

	private final ObservationUnitService observationUnitService;
	private final SearchService searchService;
	private final HttpServletRequest request;

	@Autowired
	public ObservationUnitsApiController(ObservationUnitService observationUnitService, SearchService searchService,
			HttpServletRequest request) {
		this.observationUnitService = observationUnitService;
		this.searchService = searchService;
		this.request = request;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationUnitListResponse> observationunitsGet(
			@RequestParam(value = "observationUnitDbId", required = false) String observationUnitDbId,
			@RequestParam(value = "observationUnitName", required = false) String observationUnitName,
			@RequestParam(value = "germplasmDbId", required = false) String germplasmDbId,
			@RequestParam(value = "studyDbId", required = false) String studyDbId,
			@RequestParam(value = "locationDbId", required = false) String locationDbId,
			@RequestParam(value = "trialDbId", required = false) String trialDbId,
			@RequestParam(value = "seasonDbId", required = false) String seasonDbId,
			@RequestParam(value = "includeObservations", required = false) Boolean includeObservations,
			@RequestParam(value = "observationUnitLevelName", required = false) String observationUnitLevelName,
			@RequestParam(value = "observationUnitLevelOrder", required = false) String observationUnitLevelOrder,
			@RequestParam(value = "observationUnitLevelCode", required = false) String observationUnitLevelCode,
			@RequestParam(value = "observationUnitLevelRelationshipName", required = false) String observationUnitLevelRelationshipName,
			@RequestParam(value = "observationUnitLevelRelationshipOrder", required = false) String observationUnitLevelRelationshipOrder,
			@RequestParam(value = "observationUnitLevelRelationshipCode", required = false) String observationUnitLevelRelationshipCode,
			@RequestParam(value = "observationUnitLevelRelationshipDbId", required = false) String observationUnitLevelRelationshipDbId,
			@RequestParam(value = "commonCropName", required = false) String commonCropName,
			@RequestParam(value = "programDbId", required = false) String programDbId,
			@RequestParam(value = "externalReferenceID", required = false) String externalReferenceID,
			@RequestParam(value = "externalReferenceId", required = false) String externalReferenceId,
			@RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<ObservationUnit> data = observationUnitService.findObservationUnits(observationUnitDbId,
				observationUnitName, germplasmDbId, studyDbId, locationDbId, trialDbId, programDbId, seasonDbId,
				observationUnitLevelName, observationUnitLevelOrder, observationUnitLevelCode,
				observationUnitLevelRelationshipName, observationUnitLevelRelationshipOrder,
				observationUnitLevelRelationshipCode, observationUnitLevelRelationshipDbId, commonCropName,
				includeObservations, externalReferenceId, externalReferenceID, externalReferenceSource, metadata);
		return responseOK(new ObservationUnitListResponse(), new ObservationUnitListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationUnitSingleResponse> observationunitsObservationUnitDbIdGet(
			@PathVariable("observationUnitDbId") String observationUnitDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		ObservationUnit data = observationUnitService.getObservationUnit(observationUnitDbId);
		return responseOK(new ObservationUnitSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationUnitSingleResponse> observationunitsObservationUnitDbIdPut(
			@PathVariable("observationUnitDbId") String observationUnitDbId,
			@RequestBody ObservationUnitNewRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		ObservationUnit data = observationUnitService.updateObservationUnit(observationUnitDbId, body);
		return responseOK(new ObservationUnitSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationUnitListResponse> observationunitsPost(
			@RequestBody List<ObservationUnitNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		List<ObservationUnit> data = observationUnitService.saveObservationUnits(body);
		return responseOK(new ObservationUnitListResponse(), new ObservationUnitListResponseResult(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationUnitListResponse> observationunitsPut(
			@RequestBody Map<String, ObservationUnitNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		List<ObservationUnit> data = observationUnitService.updateObservationUnits(body);
		return responseOK(new ObservationUnitListResponse(), new ObservationUnitListResponseResult(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity observationunitsTableGet(@RequestHeader(value = "Accept", required = false) String accept,
			@RequestParam(value = "observationUnitDbId", required = false) String observationUnitDbId,
			@RequestParam(value = "germplasmDbId", required = false) String germplasmDbId,
			@RequestParam(value = "observationVariableDbId", required = false) String observationVariableDbId,
			@RequestParam(value = "studyDbId", required = false) String studyDbId,
			@RequestParam(value = "locationDbId", required = false) String locationDbId,
			@RequestParam(value = "trialDbId", required = false) String trialDbId,
			@RequestParam(value = "programDbId", required = false) String programDbId,
			@RequestParam(value = "seasonDbId", required = false) String seasonDbId,
			@RequestParam(value = "observationLevel", required = false) String observationLevel,
			@RequestParam(value = "observationUnitLevelName", required = false) String observationUnitLevelName,
			@RequestParam(value = "observationUnitLevelOrder", required = false) String observationUnitLevelOrder,
			@RequestParam(value = "observationUnitLevelCode", required = false) String observationUnitLevelCode,
			@RequestParam(value = "observationUnitLevelRelationshipName", required = false) String observationUnitLevelRelationshipName,
			@RequestParam(value = "observationUnitLevelRelationshipOrder", required = false) String observationUnitLevelRelationshipOrder,
			@RequestParam(value = "observationUnitLevelRelationshipCode", required = false) String observationUnitLevelRelationshipCode,
			@RequestParam(value = "observationUnitLevelRelationshipDbId", required = false) String observationUnitLevelRelationshipDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");

		String sep = "";
		if ("text/csv".equals(accept)) {
			sep = ",";
		} else if ("text/tsv".equals(accept)) {
			sep = "\t";
		} else {
			validateAcceptHeader(request);
		}
		ObservationUnitTable data = observationUnitService.findObservationUnitsTable(observationUnitDbId, germplasmDbId,
				observationVariableDbId, studyDbId, locationDbId, trialDbId, programDbId, seasonDbId, observationLevel,
				observationUnitLevelName, observationUnitLevelOrder, observationUnitLevelCode,
				observationUnitLevelRelationshipName, observationUnitLevelRelationshipOrder,
				observationUnitLevelRelationshipCode, observationUnitLevelRelationshipDbId);
		if (sep.isEmpty()) {
			return responseOK(new ObservationUnitTableResponse(), data);
		} else {
			String textTable = observationUnitService.getObservationUnitTableText(data, sep);
			return new ResponseEntity<String>(textTable, HttpStatus.OK);
		}
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationLevelListResponse> observationlevelsGet(
			@RequestParam(value = "studyDbId", required = false) String studyDbId,
			@RequestParam(value = "trialDbId", required = false) String trialDbId,
			@RequestParam(value = "programDbId", required = false) String programDbId,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<ObservationUnitHierarchyLevel> data = observationUnitService.findObservationLevels(studyDbId, trialDbId,
				programDbId, metadata);
		return responseOK(new ObservationLevelListResponse(), new ObservationLevelListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchObservationunitsPost(
			@RequestBody ObservationUnitSearchRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(body);

		String searchReqDbId = searchService.saveSearchRequest(body, SearchRequestTypes.OBSERVATION_UNITS);
		if (searchReqDbId != null) {
			return responseAccepted(searchReqDbId);
		} else {
			List<ObservationUnit> data = observationUnitService.findObservationUnits(body, metadata);
			return responseOK(new ObservationUnitListResponse(), new ObservationUnitListResponseResult(), data,
					metadata);
		}
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchObservationunitsSearchResultsDbIdGet(
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
			ObservationUnitSearchRequest body = request.getParameters(ObservationUnitSearchRequest.class);
			List<ObservationUnit> data = observationUnitService.findObservationUnits(body, metadata);
			return responseOK(new ObservationUnitListResponse(), new ObservationUnitListResponseResult(), data,
					metadata);
		} else {
			return responseAccepted(searchResultsDbId);
		}
	}

}
