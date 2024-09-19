package com.hashedin.restaurant_service.eexceptionHandler;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity handleResponseStatusException(ResponseStatusException ex, WebRequest request) {
        CustomErrorResponse errorResponse = new CustomErrorResponse();
        errorResponse.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        errorResponse.setStatus(ex.getStatusCode().value());
        errorResponse.setMessage(ex.getReason());
        errorResponse.setPath(request.getDescription(false).substring(4)); // Remove 'uri=' prefix

        return new ResponseEntity<>(errorResponse, HttpStatusCode.valueOf(ex.getStatusCode().value()));
    }
}
