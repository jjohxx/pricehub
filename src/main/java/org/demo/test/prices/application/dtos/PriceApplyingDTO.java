package org.demo.test.prices.application.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Data Transfer Object (DTO) representing information for applying prices.
 */
@Getter
@Setter
@Builder
public class PriceApplyingDTO {

    private LocalDateTime applicationDate;
    private Long productId;
    private String stringIdentifier;
}
