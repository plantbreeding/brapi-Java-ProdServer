package org.brapi.test.BrAPITestServer.controller.pheno;

import io.swagger.model.Metadata;
import io.swagger.model.pheno.Scale;
import io.swagger.model.pheno.ScaleListResponse;
import io.swagger.model.pheno.ScaleListResponseResult;
import io.swagger.model.pheno.ScaleSingleResponse;
import io.swagger.model.pheno.ScaleBaseClass;
import io.swagger.api.pheno.ScalesApi;

import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.pheno.ScaleService;
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
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

@javax.annotation.processing.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:22.556Z[GMT]")
@Controller
public class ScalesApiController extends BrAPIController implements ScalesApi {

	private static final Logger log = LoggerFactory.getLogger(ScalesApiController.class);

	private final ScaleService scaleService;

	private final HttpServletRequest request;

	@Autowired
	public ScalesApiController(ScaleService scaleService, HttpServletRequest request) {
		this.scaleService = scaleService;
		this.request = request;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ScaleListResponse> scalesGet(
			@RequestParam(value = "scaleDbId", required = false) String scaleDbId,
			@RequestParam(value = "observationVariableDbId", required = false) String observationVariableDbId,
			@RequestParam(value = "ontologyDbId", required = false) String ontologyDbId,
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
		List<Scale> data = scaleService.findScales(scaleDbId, observationVariableDbId, ontologyDbId, commonCropName,
				programDbId, externalReferenceId, externalReferenceID, externalReferenceSource, metadata);
		return responseOK(new ScaleListResponse(), new ScaleListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ScaleListResponse> scalesPost(@RequestBody List<ScaleBaseClass> body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		List<Scale> data = scaleService.saveScales(body);
		return responseOK(new ScaleListResponse(), new ScaleListResponseResult(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ScaleSingleResponse> scalesScaleDbIdGet(@PathVariable("scaleDbId") String scaleDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Scale data = scaleService.getScale(scaleDbId);
		return responseOK(new ScaleSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ScaleSingleResponse> scalesScaleDbIdPut(@PathVariable("scaleDbId") String scaleDbId,
			@RequestBody ScaleBaseClass body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		Scale data = scaleService.updateScale(scaleDbId, body);
		return responseOK(new ScaleSingleResponse(), data);
	}

}
