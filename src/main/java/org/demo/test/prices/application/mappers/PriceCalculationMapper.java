package org.demo.test.prices.application.mappers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.demo.test.prices.application.dtos.PriceCalculationDTO;
import org.demo.test.prices.domain.models.PriceCalculation;

/**
 * Mapper class for converting between PriceCalculation domain models and PriceCalculationDTOs.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PriceCalculationMapper {

    /**
     * Convert PriceCalculationDTO to PriceCalculation model.
     *
     * @param dto PriceCalculationDTO to be converted
     * @return PriceCalculation representing the converted DTO
     */
    public static PriceCalculation toModel(final PriceCalculationDTO dto) {
        return PriceCalculation.builder()
                .productId(dto.getProductId())
                .chainIdentifier(dto.getChainIdentifier())
                .rateToApply(dto.getRateToApply())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .finalPrice(dto.getFinalPrice())
                .currency(dto.getCurrency())
                .build();
    }

    /**
     * Convert PriceCalculation model to PriceCalculationDTO.
     *
     * @param model PriceCalculation model to be converted
     * @return PriceCalculationDTO representing the converted model
     */
    public static PriceCalculationDTO fromModel(final PriceCalculation model) {
        return PriceCalculationDTO.builder()
                .productId(model.getProductId())
                .chainIdentifier(model.getChainIdentifier())
                .rateToApply(model.getRateToApply())
                .startDate(model.getStartDate())
                .endDate(model.getEndDate())
                .finalPrice(model.getFinalPrice())
                .currency(model.getCurrency())
                .build();
    }
}
