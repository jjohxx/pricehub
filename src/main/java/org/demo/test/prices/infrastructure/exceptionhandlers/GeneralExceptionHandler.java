package org.demo.test.prices.infrastructure.exceptionhandlers;

import org.demo.test.prices.infrastructure.validation.ErrorsDetails;
import org.demo.test.prices.infrastructure.validation.exceptions.DTOException;
import org.demo.test.prices.infrastructure.validation.exceptions.DTOException.ErrorResponse;
import org.demo.test.prices.infrastructure.validation.exceptions.PriceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

/**
 * Exception handlers for general exceptions in the infrastructure layer.
 */
@RestControllerAdvice
public class GeneralExceptionHandler {

    /**
     * Handles DTOException.
     *
     * @param exception The DTOException to handle
     * @return ResponseEntity containing the error response and status
     */
    @ExceptionHandler(DTOException.class)
    public ResponseEntity<ErrorResponse> handleDtoException(DTOException exception) {
        return ResponseEntity.status(exception.getStatus()).body(exception.getResponse());
    }

    /**
     * Handles MethodArgumentNotValidException.
     *
     * @param ex The MethodArgumentNotValidException to handle
     * @return ResponseEntity containing the error response and status
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        final List<ErrorsDetails> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.add(new ErrorsDetails(fieldName, errorMessage));
        });
        final ErrorResponse errorResponse = new ErrorResponse(errors, HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    /**
     * Handles PriceNotFoundException.
     *
     * @param ex The PriceNotFoundException to handle
     * @return ResponseEntity containing the error response and status
     */
    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePriceNotFoundException(PriceNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
