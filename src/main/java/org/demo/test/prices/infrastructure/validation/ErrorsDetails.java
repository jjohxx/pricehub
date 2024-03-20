package org.demo.test.prices.infrastructure.validation;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Details of validation errors.
 */
@Data
@AllArgsConstructor
public class ErrorsDetails {

    /**
     * The field associated with the error.
     */
    private String field;

    /**
     * The error message.
     */
    private String errorMessage;
}
