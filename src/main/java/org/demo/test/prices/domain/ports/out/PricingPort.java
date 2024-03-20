package org.demo.test.prices.domain.ports.out;

import org.demo.test.prices.domain.models.Price;
import org.demo.test.prices.domain.models.PriceApplying;
import org.demo.test.prices.domain.models.PriceCalculation;
import org.demo.test.prices.domain.ports.operations.CalculateOperation;
import org.demo.test.prices.domain.ports.operations.CreateOperation;
import org.demo.test.prices.domain.ports.operations.RetrievalOperation;

/**
 * Interface representing a port for pricing operations.
 */
public interface PricingPort extends CreateOperation<Price>, RetrievalOperation<Price>,
        CalculateOperation<PriceApplying, PriceCalculation> {
}
