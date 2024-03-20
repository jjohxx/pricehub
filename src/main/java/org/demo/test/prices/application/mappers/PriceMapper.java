package org.demo.test.prices.application.mappers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.demo.test.prices.application.dtos.PriceDTO;
import org.demo.test.prices.domain.models.Price;
import org.demo.test.prices.infrastructure.aggregates.PriceAggregate;

/**
 * Mapper class for converting between Price domain models, PriceDTOs, and PriceAggregates.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PriceMapper {

    /**
     * Convert Price entity to PriceAggregate.
     *
     * @param entity Price entity to be converted
     * @return PriceAggregate representing the converted entity
     */
    public static PriceAggregate fromDomainModel(final Price entity) {
        return PriceAggregate.builder()
                .id(entity.getId())
                .price(entity.getPrice())
                .priority(entity.getPriority())
                .productId(entity.getProductId())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .priceList(entity.getPriceList())
                .brandId(entity.getBrandId())
                .currency(entity.getCurrency())
                .build();
    }

    /**
     * Convert PriceAggregate to Price entity.
     *
     * @param aggregate PriceAggregate to be converted
     * @return Price representing the converted aggregate
     */
    public static Price toDomainModel(final PriceAggregate aggregate) {
        return Price.builder()
                .id(aggregate.getId())
                .price(aggregate.getPrice())
                .priority(aggregate.getPriority())
                .productId(aggregate.getProductId())
                .startDate(aggregate.getStartDate())
                .endDate(aggregate.getEndDate())
                .priceList(aggregate.getPriceList())
                .brandId(aggregate.getBrandId())
                .currency(aggregate.getCurrency())
                .build();
    }

    /**
     * Convert PriceDTO to Price entity.
     *
     * @param dto PriceDTO to be converted
     * @return Price representing the converted DTO
     */
    public static Price toModel(final PriceDTO dto) {
        return Price.builder()
                .id(dto.getId())
                .price(dto.getPrice())
                .priority(dto.getPriority())
                .productId(dto.getProductId())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .priceList(dto.getPriceList())
                .brandId(dto.getBrandId())
                .currency(dto.getCurrency())
                .build();
    }

    /**
     * Convert Price entity to PriceDTO.
     *
     * @param entity Price entity to be converted
     * @return PriceDTO representing the converted entity
     */
    public static PriceDTO fromModel(final Price entity) {
        return PriceDTO.builder()
                .id(entity.getId())
                .price(entity.getPrice())
                .priority(entity.getPriority())
                .productId(entity.getProductId())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .priceList(entity.getPriceList())
                .brandId(entity.getBrandId())
                .currency(entity.getCurrency())
                .build();
    }
}
