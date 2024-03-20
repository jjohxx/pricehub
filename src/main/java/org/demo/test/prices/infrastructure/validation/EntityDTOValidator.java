/**
 * Abstract class for validating entity DTOs.
 *
 * @param <D> The type of DTO to validate
 */
package org.demo.test.prices.infrastructure.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;
import org.demo.test.prices.infrastructure.validation.exceptions.DTOException;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class EntityDTOValidator<D> implements ValidatorDTO<D> {

    /**
     * Validates the given DTO.
     *
     * @param dto The DTO to validate
     * @throws DTOException if validation fails
     */
    @Override
    public void validate(final D dto) throws DTOException {
        List<ErrorsDetails> errors = new ArrayList<>();
        errors.addAll(getBeanValidationErrors(dto));
        errors.addAll(additionalValidations(dto));

        if (!errors.isEmpty()) {
            throw new DTOException(errors, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Performs additional validations specific to the DTO.
     *
     * @param dto The DTO to validate
     * @return List of additional validation errors
     */
    protected abstract List<ErrorsDetails> additionalValidations(final D dto);

    /**
     * Retrieves Bean Validation errors for the DTO.
     *
     * @param dto The DTO to validate
     * @return List of Bean Validation errors
     */
    private List<ErrorsDetails> getBeanValidationErrors(D dto) {

        try (ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory()) {
            Set<ConstraintViolation<D>> violations = validatorFactory.getValidator().validate(dto);
            return violations.stream().map(violation -> new ErrorsDetails(
                            violation.getPropertyPath().toString(),
                            StringUtils.capitalize(violation.getMessage())))
                    .toList();
        }
    }
}
