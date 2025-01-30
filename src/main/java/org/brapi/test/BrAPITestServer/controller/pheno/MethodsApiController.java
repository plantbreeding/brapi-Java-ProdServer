package org.brapi.test.BrAPITestServer.controller.pheno;

import io.swagger.model.Metadata;
import io.swagger.model.pheno.Method;
import io.swagger.model.pheno.MethodBaseClass;
import io.swagger.model.pheno.MethodListResponse;
import io.swagger.model.pheno.MethodListResponseResult;
import io.swagger.model.pheno.MethodSingleResponse;
import io.swagger.api.pheno.MethodsApi;

import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.pheno.MethodService;
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
public class MethodsApiController extends BrAPIController implements MethodsApi {

	private static final Logger log = LoggerFactory.getLogger(MethodsApiController.class);

	private final MethodService methodService;

	private final HttpServletRequest request;

	@Autowired
	public MethodsApiController(MethodService methodService, HttpServletRequest request) {
		this.methodService = methodService;
		this.request = request;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<MethodListResponse> methodsGet(
			@RequestParam(value = "methodDbId", required = false) String methodDbId,
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
		List<Method> data = methodService.findMethods(methodDbId, observationVariableDbId, ontologyDbId, commonCropName,
				programDbId, externalReferenceId, externalReferenceID, externalReferenceSource, metadata);
		return responseOK(new MethodListResponse(), new MethodListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<MethodSingleResponse> methodsMethodDbIdGet(@PathVariable("methodDbId") String methodDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Method data = methodService.getMethod(methodDbId);
		return responseOK(new MethodSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<MethodSingleResponse> methodsMethodDbIdPut(@PathVariable("methodDbId") String methodDbId,
			@RequestBody MethodBaseClass body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		Method data = methodService.updateMethod(methodDbId, body);
		return responseOK(new MethodSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<MethodListResponse> methodsPost(@RequestBody List<MethodBaseClass> body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		List<Method> data = methodService.saveMethods(body);
		return responseOK(new MethodListResponse(), new MethodListResponseResult(), data);
	}

}
