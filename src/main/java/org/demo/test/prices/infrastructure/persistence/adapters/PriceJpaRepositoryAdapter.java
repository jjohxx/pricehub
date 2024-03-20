package org.demo.test.prices.infrastructure.persistence.adapters;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.demo.test.prices.application.mappers.PriceMapper;
import org.demo.test.prices.domain.models.Price;
import org.demo.test.prices.domain.models.PriceApplying;
import org.demo.test.prices.domain.models.PriceCalculation;
import org.demo.test.prices.domain.ports.out.PricingPort;
import org.demo.test.prices.infrastructure.aggregates.PriceAggregate;
import org.demo.test.prices.infrastructure.persistence.repositories.PriceJpaRepository;
import org.demo.test.prices.infrastructure.validation.exceptions.PriceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Adapter for interacting with the PriceJpaRepository as a PricingPort.
 */
@Component
@AllArgsConstructor
public class PriceJpaRepositoryAdapter implements PricingPort {

    private final PriceJpaRepository repository;

    /**
     * Creates a new price entity.
     *
     * @param entity The price entity to be created
     * @return The created price entity
     */
    @Override
    public Price create(final Price entity) {
        PriceAggregate priceAggregate = PriceMapper.fromDomainModel(entity);
        return PriceMapper.toDomainModel(repository.save(priceAggregate));
    }

    /**
     * Retrieves all price entities.
     *
     * @return List of all price entities
     */
    @Override
    public List<Price> getAll() {
        return repository.findAll().stream().map(PriceMapper::toDomainModel)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a price entity by its identifier.
     *
     * @param id The identifier of the price entity to retrieve
     * @return The retrieved price entity
     * @throws EntityNotFoundException if the price entity with the provided id does not exist
     */
    @Override
    public Price getById(final Long id) {
        return repository.findById(id).map(PriceMapper::toDomainModel)
                .orElseThrow(EntityNotFoundException::new);
    }

    /**
     * Calculates price based on the given applying information.
     *
     * @param request The applying information for price calculation
     * @return The calculated price
     */
    @Override
    public PriceCalculation calculate(final PriceApplying request) {
        List<PriceAggregate> prices = repository.findByProductIdAndStartDateBeforeAndEndDateAfter(
                request.getProductId(), request.getApplicationDate(), request.getApplicationDate());

        final PriceAggregate applicablePrice = selectApplicablePrice(prices, request.getProductId());

        return PriceCalculation.builder()
                .productId(applicablePrice.getProductId())
                .chainIdentifier(request.getStringIdentifier())
                .rateToApply(applicablePrice.getPriceList())
                .startDate(applicablePrice.getStartDate())
                .endDate(applicablePrice.getEndDate())
                .finalPrice(applicablePrice.getPrice())
                .currency(applicablePrice.getCurrency())
                .build();
    }

    /**
     * Selects the applicable price from a list of prices.
     *
     * @param prices    List of prices to select from
     * @param productId The identifier of the product
     * @return The selected applicable price
     * @throws PriceNotFoundException if no applicable price is found
     */
    private PriceAggregate selectApplicablePrice(List<PriceAggregate> prices, Long productId) {
        if (prices.isEmpty()) {
            throw new PriceNotFoundException(productId);
        }

        prices.sort((price1, price2) -> price2.getPriority().compareTo(price1.getPriority()));
        return prices.get(0);
    }
}
