package org.demo.test.prices.domain.models;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Represents a calculation of price for a product.
 */
@Data
@Builder
public class PriceCalculation {

    private Long productId;
    private String chainIdentifier;
    private Integer rateToApply;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal finalPrice;
    private String currency;
}
