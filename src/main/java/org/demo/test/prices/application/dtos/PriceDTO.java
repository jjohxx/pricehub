package org.demo.test.prices.application.dtos;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.demo.test.prices.domain.models.PricePriority;
import org.demo.test.prices.infrastructure.validation.annotations.ISOCurrency;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.demo.test.prices.infrastructure.validation.ValidationConstants.DATE_TIME_FORMAT;

/**
 * Data Transfer Object (DTO) representing price information.
 */
@Getter
@Setter
@Builder
public class PriceDTO {

    private Long id;

    @NotNull
    @Positive
    private Long brandId;

    @NotNull
    @DateTimeFormat(pattern = DATE_TIME_FORMAT)
    private LocalDateTime startDate;

    @NotNull
    @DateTimeFormat(pattern = DATE_TIME_FORMAT)
    private LocalDateTime endDate;

    @NotNull
    @Positive
    private Integer priceList;

    @NotNull
    @Positive
    private Long productId;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PricePriority priority;

    @NotNull
    @Positive
    private BigDecimal price;

    @NotNull
    @Size(min = 3, max = 3)
    @ISOCurrency
    private String currency;
}
