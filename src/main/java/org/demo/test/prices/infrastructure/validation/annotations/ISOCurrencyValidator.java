package org.demo.test.prices.infrastructure.validation.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Currency;

/**
 * Validator for ISOCurrency annotation.
 */
public class ISOCurrencyValidator implements ConstraintValidator<ISOCurrency, String> {

    /**
     * Initializes the validator.
     *
     * @param constraintAnnotation The ISOCurrency constraint annotation
     */
    @Override
    public void initialize(ISOCurrency constraintAnnotation) {
    }

    /**
     * Validates the given ISO currency code.
     *
     * @param value   The ISO currency code to validate
     * @param context The validation context
     * @return True if the value is a valid ISO currency code, otherwise false
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null
                && Currency.getAvailableCurrencies().stream()
                .anyMatch(currency -> currency.getCurrencyCode().equals(value));
    }
}
