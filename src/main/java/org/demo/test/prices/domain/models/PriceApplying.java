package org.demo.test.prices.domain.models;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Represents an application of price to a product.
 */
@Data
@Builder
public class PriceApplying {

    private LocalDateTime applicationDate;
    private Long productId;
    private String stringIdentifier;
}
