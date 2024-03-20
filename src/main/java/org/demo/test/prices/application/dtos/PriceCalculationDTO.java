package org.demo.test.prices.application.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Data Transfer Object (DTO) representing information for price calculations.
 */
@Getter
@Setter
@Builder
public class PriceCalculationDTO {

    private Long productId;
    private String chainIdentifier;
    private Integer rateToApply;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal finalPrice;
    private String currency;
}
