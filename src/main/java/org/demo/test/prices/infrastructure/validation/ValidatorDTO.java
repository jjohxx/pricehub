package org.demo.test.prices.infrastructure.validation;

import org.demo.test.prices.infrastructure.validation.exceptions.DTOException;

/**
 * Interface for DTO validators.
 *
 * @param <D> The type of DTO to validate
 */
public interface ValidatorDTO<D> {

    /**
     * Validates the given DTO.
     *
     * @param dto The DTO to validate
     * @throws DTOException if validation fails
     */
    void validate(D dto) throws DTOException;
}
