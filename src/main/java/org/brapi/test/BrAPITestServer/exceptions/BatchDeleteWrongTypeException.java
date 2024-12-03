package org.brapi.test.BrAPITestServer.exceptions;

import io.swagger.model.core.BatchTypes;
import org.springframework.http.HttpStatus;

public class BatchDeleteWrongTypeException extends BrAPIServerException {
    public BatchDeleteWrongTypeException(String msg, HttpStatus status) { super(status, ""); }

    public BatchDeleteWrongTypeException(BatchTypes requiredType, BatchTypes suppliedType, String batchDeleteDbId, HttpStatus status) {
        super(status, "");
        String msg = "The " + suppliedType.toString() + " batch delete " + batchDeleteDbId + " must be of type " + requiredType.toString();
    }
}
