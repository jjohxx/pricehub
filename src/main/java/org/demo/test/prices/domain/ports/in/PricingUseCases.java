package org.demo.test.prices.domain.ports.in;

import org.demo.test.prices.application.dtos.PriceApplyingDTO;
import org.demo.test.prices.application.dtos.PriceCalculationDTO;
import org.demo.test.prices.application.dtos.PriceDTO;
import org.demo.test.prices.domain.ports.operations.CalculateOperation;
import org.demo.test.prices.domain.ports.operations.CreateOperation;
import org.demo.test.prices.domain.ports.operations.RetrievalOperation;

/**
 * PricingUseCases represent behavior contract to assure Price will work same way always.
 */
public interface PricingUseCases extends CreateOperation<PriceDTO>, RetrievalOperation<PriceDTO>,
        CalculateOperation<PriceApplyingDTO, PriceCalculationDTO> {

}
