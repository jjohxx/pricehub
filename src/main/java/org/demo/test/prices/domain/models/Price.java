package org.demo.test.prices.domain.models;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * This class in the domain entity representation of Price.
 */
@Data
@Builder
public class Price {

    private Long id;

    private Long brandId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Integer priceList;

    private Long productId;

    private PricePriority priority;

    private BigDecimal price;

    private String currency;
}
