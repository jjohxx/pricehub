package org.demo.test.prices.application.usecases;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.demo.test.prices.application.dtos.PriceApplyingDTO;
import org.demo.test.prices.application.dtos.PriceCalculationDTO;
import org.demo.test.prices.application.dtos.PriceDTO;
import org.demo.test.prices.application.mappers.PriceApplyingMapper;
import org.demo.test.prices.application.mappers.PriceCalculationMapper;
import org.demo.test.prices.application.mappers.PriceMapper;
import org.demo.test.prices.domain.ports.in.PricingUseCases;
import org.demo.test.prices.domain.ports.out.PricingPort;
import org.demo.test.prices.infrastructure.validation.PriceDTOValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of use cases related to pricing operations.
 */
@Service
@AllArgsConstructor
public class PricingUseCasesImpl implements PricingUseCases {

    private final PricingPort pricingPort;
    private final PriceDTOValidator validator;

    /**
     * Create a new price entity.
     *
     * @param entity PriceDTO representing the price to be created
     * @return PriceDTO representing the created price entity
     */
    @Override
    public PriceDTO create(final PriceDTO entity) {
        validator.validate(entity);
        return PriceMapper.fromModel(pricingPort.create(PriceMapper.toModel(entity)));
    }

    /**
     * Get all price entities.
     *
     * @return List of PriceDTO representing all price entities
     */
    @Override
    public List<PriceDTO> getAll() {
        return pricingPort.getAll().stream().map(PriceMapper::fromModel)
                .collect(Collectors.toList());
    }

    /**
     * Get a price entity by its identifier.
     *
     * @param id Identifier of the price entity to retrieve
     * @return PriceDTO representing the retrieved price entity
     * @throws EntityNotFoundException if the entity with the provided id does not exist
     */
    @Override
    public PriceDTO getById(final Long id) {
        return Optional.of(pricingPort.getById(id)).map(PriceMapper::fromModel).orElseThrow(
                EntityNotFoundException::new);
    }

    /**
     * Calculate price based on the given applying information.
     *
     * @param request PriceApplyingDTO containing information for price calculation
     * @return PriceCalculationDTO representing the calculated price
     */
    @Override
    public PriceCalculationDTO calculate(final PriceApplyingDTO request) {
        return PriceCalculationMapper.fromModel(pricingPort.calculate(PriceApplyingMapper.toModel(
                request)));
    }
}
