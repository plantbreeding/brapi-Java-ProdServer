package org.brapi.test.BrAPITestServer.controller.germ;

import io.swagger.model.BrAPIResponse;
import io.swagger.model.Metadata;
import io.swagger.model.germ.GermplasmAttribute;
import io.swagger.model.germ.GermplasmAttributeCategoryListResponse;
import io.swagger.model.germ.GermplasmAttributeCategoryListResponseResult;
import io.swagger.model.germ.GermplasmAttributeListResponse;
import io.swagger.model.germ.GermplasmAttributeListResponseResult;
import io.swagger.model.germ.GermplasmAttributeNewRequest;
import io.swagger.model.germ.GermplasmAttributeSearchRequest;
import io.swagger.model.germ.GermplasmAttributeSingleResponse;
import io.swagger.api.germ.AttributesApi;

import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity.SearchRequestTypes;
import org.brapi.test.BrAPITestServer.service.SearchService;
import org.brapi.test.BrAPITestServer.service.germ.GermplasmAttributeService;
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

@javax.annotation.processing.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
@Controller
public class AttributesApiController extends BrAPIController implements AttributesApi {

	private static final Logger log = LoggerFactory.getLogger(AttributesApiController.class);

	private final GermplasmAttributeService attributeService;
	private final SearchService searchService;
	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public AttributesApiController(GermplasmAttributeService attributeService, SearchService searchService,
			HttpServletRequest request) {
		this.attributeService = attributeService;
		this.searchService = searchService;
		this.request = request;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<GermplasmAttributeCategoryListResponse> attributesCategoriesGet(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		validateAcceptHeader(request);
		log.debug("Request: " + request.getRequestURI());

		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<String> crops = attributeService.getAttributesCategories(metadata);
		return responseOK(new GermplasmAttributeCategoryListResponse(),
				new GermplasmAttributeCategoryListResponseResult(), crops, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<GermplasmAttributeListResponse> attributesGet(
			@RequestParam(value = "attributeCategory", required = false) String attributeCategory,
			@RequestParam(value = "attributeDbId", required = false) String attributeDbId,
			@RequestParam(value = "attributeName", required = false) String attributeName,
			@RequestParam(value = "attributePUI", required = false) String attributePUI,
			@RequestParam(value = "germplasmDbId", required = false) String germplasmDbId,
			@RequestParam(value = "methodDbId", required = false) String methodDbId,
			@RequestParam(value = "methodName", required = false) String methodName,
			@RequestParam(value = "methodPUI", required = false) String methodPUI,
			@RequestParam(value = "scaleDbId", required = false) String scaleDbId,
			@RequestParam(value = "scaleName", required = false) String scaleName,
			@RequestParam(value = "scalePUI", required = false) String scalePUI,
			@RequestParam(value = "traitDbId", required = false) String traitDbId,
			@RequestParam(value = "traitName", required = false) String traitName,
			@RequestParam(value = "traitPUI", required = false) String traitPUI,
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
		List<GermplasmAttribute> data = attributeService.findGermplasmAttributes(attributeCategory, attributeDbId,
				attributeName, attributePUI, germplasmDbId, methodDbId, methodName, methodPUI, scaleDbId, scaleName,
				scalePUI, traitDbId, traitName, traitPUI, commonCropName, programDbId, externalReferenceId,
				externalReferenceID, externalReferenceSource, metadata);
		return responseOK(new GermplasmAttributeListResponse(), new GermplasmAttributeListResponseResult(), data,
				metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<GermplasmAttributeListResponse> attributesPost(
			@RequestBody List<GermplasmAttributeNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		List<GermplasmAttribute> data = attributeService.saveGermplasmAttributes(body);
		return responseOK(new GermplasmAttributeListResponse(), new GermplasmAttributeListResponseResult(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<GermplasmAttributeSingleResponse> attributesAttributeDbIdGet(
			@PathVariable("attributeDbId") String attributeDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		GermplasmAttribute data = attributeService.getGermplasmAttribute(attributeDbId);
		return responseOK(new GermplasmAttributeSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<GermplasmAttributeSingleResponse> attributesAttributeDbIdPut(
			@PathVariable("attributeDbId") String attributeDbId, @RequestBody GermplasmAttributeNewRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		GermplasmAttribute data = attributeService.updateGermplasmAttribute(attributeDbId, body);
		return responseOK(new GermplasmAttributeSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchAttributesPost(
			@RequestBody GermplasmAttributeSearchRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(body);

		String searchReqDbId = searchService.saveSearchRequest(body, SearchRequestTypes.GERMPLASM_ATTRIBUTES);
		if (searchReqDbId != null) {
			return responseAccepted(searchReqDbId);
		} else {
			List<GermplasmAttribute> data = attributeService.findGermplasmAttributes(body, metadata);
			return responseOK(new GermplasmAttributeListResponse(), new GermplasmAttributeListResponseResult(), data,
					metadata);
		}
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchAttributesSearchResultsDbIdGet(
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
			GermplasmAttributeSearchRequest body = request.getParameters(GermplasmAttributeSearchRequest.class);
			List<GermplasmAttribute> data = attributeService.findGermplasmAttributes(body, metadata);
			return responseOK(new GermplasmAttributeListResponse(), new GermplasmAttributeListResponseResult(), data,
					metadata);
		} else {
			return responseAccepted(searchResultsDbId);
		}
	}
}
