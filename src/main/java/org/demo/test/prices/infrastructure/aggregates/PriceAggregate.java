package org.demo.test.prices.infrastructure.aggregates;

import jakarta.persistence.*;
import lombok.*;
import org.demo.test.prices.domain.models.PricePriority;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Represents an aggregated form of price information.
 */
@Getter
@Setter
@Entity
@Table(name = "price")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PriceAggregate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long brandId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Integer priceList;

    private Long productId;

    @Enumerated(EnumType.ORDINAL)
    private PricePriority priority;

    private BigDecimal price;

    private String currency;
}
