package org.demo.test.prices.infrastructure.persistence.repositories;

import org.demo.test.prices.infrastructure.aggregates.PriceAggregate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Repository interface for PriceAggregate entities.
 */
@Repository
public interface PriceJpaRepository extends JpaRepository<PriceAggregate, Long> {

    /**
     * Retrieves price aggregates by product ID and within a specified date range.
     *
     * @param productId The identifier of the product
     * @param startDate The start date of the date range
     * @param endDate   The end date of the date range
     * @return List of price aggregates matching the criteria
     */
    List<PriceAggregate> findByProductIdAndStartDateBeforeAndEndDateAfter(
            Long productId,
            LocalDateTime startDate, LocalDateTime endDate);
}
