package org.demo.test.prices.infrastructure.validation;

import org.demo.test.prices.application.dtos.PriceDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Validator for PriceDTO entities.
 */
@Component
public class PriceDTOValidator extends EntityDTOValidator<PriceDTO> {

    /**
     * Performs additional validations specific to PriceDTO.
     *
     * @param dto The PriceDTO to validate
     * @return List of additional validation errors
     */
    @Override
    protected List<ErrorsDetails> additionalValidations(final PriceDTO dto) {
        return new ArrayList<>(); // No additional validation for now.
    }
}
