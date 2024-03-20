package org.demo.test.prices.infrastructure.validation.exceptions;

import lombok.Getter;
import org.demo.test.prices.infrastructure.validation.ErrorsDetails;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

import static org.demo.test.prices.infrastructure.validation.exceptions.DTOException.ErrorResponse.VALIDATION_ERROR_MESSAGE;

@Getter
public class DTOException extends RuntimeException {

    /**
     * The list of detailed errors.
     */
    private final List<ErrorsDetails> errors;

    /**
     * The HTTP status associated with the exception.
     */
    private final HttpStatus status;

    /**
     * The error message associated with the exception.
     */
    private final String errorMessage;

    /**
     * Constructs a new DTOException with the specified errors and HTTP status.
     *
     * @param errors The list of detailed errors
     * @param status The HTTP status associated with the exception
     */
    public DTOException(
            final List<ErrorsDetails> errors, final HttpStatus status) {
        this.errors = errors;
        this.status = status;
        this.errorMessage = VALIDATION_ERROR_MESSAGE;
    }

    /**
     * Get the error response object.
     *
     * @return The error response object
     */
    public ErrorResponse getResponse() {
        return new ErrorResponse(getErrors(), getStatus(), getErrorMessage());
    }

    /**
     * Response class for DTOException.
     */
    @Getter
    public static class ErrorResponse {

        /**
         * The default validation error message.
         */
        public static final String VALIDATION_ERROR_MESSAGE = "Validation Error Messages!";

        /**
         * The list of detailed errors.
         */
        private final List<ErrorsDetails> errors;

        /**
         * The HTTP status associated with the response.
         */
        private final HttpStatus status;

        /**
         * The error message associated with the response.
         */
        private final String errorMessage;

        /**
         * Constructs a new ErrorResponse with the specified errors and HTTP status.
         *
         * @param errors The list of detailed errors
         * @param status The HTTP status associated with the response
         */
        public ErrorResponse(
                final List<ErrorsDetails> errors, final HttpStatus status) {
            this(errors, status, VALIDATION_ERROR_MESSAGE);
        }

        /**
         * Constructs a new ErrorResponse with the specified error message and HTTP status.
         *
         * @param errorMessage The error message associated with the response
         * @param status       The HTTP status associated with the response
         */
        public ErrorResponse(
                final String errorMessage, final HttpStatus status) {
            this(Collections.emptyList(), status, errorMessage);
        }

        /**
         * Constructs a new ErrorResponse with the specified errors, error message, and HTTP status.
         *
         * @param errors       The list of detailed errors
         * @param status       The HTTP status associated with the response
         * @param errorMessage The error message associated with the response
         */
        public ErrorResponse(
                final List<ErrorsDetails> errors, final HttpStatus status, final String errorMessage) {
            this.errors = errors;
            this.status = status;
            this.errorMessage = errorMessage;
        }
    }
}