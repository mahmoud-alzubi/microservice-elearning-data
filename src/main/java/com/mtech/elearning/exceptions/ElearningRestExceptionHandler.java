package com.mtech.elearning.exceptions;

import com.mtech.elearning.response.ElearningErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ElearningRestExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    ///////////////////////////////////////////////

    /**
     * To Handle NotFoundException
     *
     * @param e
     * @return
     */
    @ExceptionHandler
    ResponseEntity<?> handleException(ElearningNotFoundException e) {
        ElearningErrorResponse errorResponse = new ElearningErrorResponse()
                .withStatus(HttpStatus.NOT_FOUND.value())
                .withMessage(e.getMessage())
                .withTimestamp(System.currentTimeMillis());
        logger.error(errorResponse.toString());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    ///////////////////////////////////////////////

    /**
     * To Handle Others Exceptions
     *
     * @param e
     * @return
     */
    @ExceptionHandler
    ResponseEntity<?> handleException(Exception e) {
        ElearningErrorResponse errorResponse = new ElearningErrorResponse()
                .withStatus(HttpStatus.BAD_REQUEST.value())
                .withMessage(e.getMessage())
                .withTimestamp(System.currentTimeMillis());
        logger.error(errorResponse.toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

}
