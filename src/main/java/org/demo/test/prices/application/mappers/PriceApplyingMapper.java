package org.demo.test.prices.application.mappers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.demo.test.prices.application.dtos.PriceApplyingDTO;
import org.demo.test.prices.domain.models.PriceApplying;

/**
 * Mapper class for converting between PriceApplying domain models and PriceApplyingDTOs.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PriceApplyingMapper {

    /**
     * Convert PriceApplyingDTO to PriceApplying model.
     *
     * @param dto PriceApplyingDTO to be converted
     * @return PriceApplying representing the converted DTO
     */
    public static PriceApplying toModel(final PriceApplyingDTO dto) {
        return PriceApplying.builder()
                .applicationDate(dto.getApplicationDate())
                .productId(dto.getProductId())
                .stringIdentifier(dto.getStringIdentifier())
                .build();
    }

    /**
     * Convert PriceApplying model to PriceApplyingDTO.
     *
     * @param model PriceApplying model to be converted
     * @return PriceApplyingDTO representing the converted model
     */
    public static PriceApplyingDTO fromModel(final PriceApplying model) {
        return PriceApplyingDTO.builder()
                .applicationDate(model.getApplicationDate())
                .productId(model.getProductId())
                .stringIdentifier(model.getStringIdentifier())
                .build();
    }
}

