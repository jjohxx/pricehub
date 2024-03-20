package org.demo.test.prices.infrastructure.validation.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * Annotation for validating ISO currency codes.
 */
@Documented
@Constraint(validatedBy = ISOCurrencyValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ISOCurrency {

    /**
     * Default message for validation failure.
     *
     * @return The default error message
     */
    String message() default "Invalid ISO currency code";

    /**
     * Groups targeted for validation.
     *
     * @return The targeted validation groups
     */
    Class<?>[] groups() default {};

    /**
     * Payload for custom metadata.
     *
     * @return The payload for custom metadata
     */
    Class<? extends Payload>[] payload() default {};
}
