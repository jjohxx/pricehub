package org.demo.test.prices.infrastructure.web;

import lombok.AllArgsConstructor;
import org.demo.test.prices.application.dtos.PriceApplyingDTO;
import org.demo.test.prices.application.dtos.PriceCalculationDTO;
import org.demo.test.prices.application.dtos.PriceDTO;
import org.demo.test.prices.domain.ports.in.PricingUseCases;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for handling price-related operations.
 */
@RestController
@RequestMapping("/prices")
@AllArgsConstructor
@Validated
public class PriceController {

    /**
     * The use cases for pricing operations.
     */
    private final PricingUseCases pricingUseCases;

    /**
     * Calculates the price based on the applying DTO.
     *
     * @param priceApplyingDTO The applying DTO containing necessary information
     * @return ResponseEntity containing the calculated price
     */
    @PostMapping("/calculate")
    public ResponseEntity<PriceCalculationDTO> calculate(@RequestBody PriceApplyingDTO priceApplyingDTO) {
        return ResponseEntity.ok(pricingUseCases.calculate(priceApplyingDTO));
    }

    /**
     * Creates a new price based on the provided DTO.
     *
     * @param priceDTO The DTO containing the details of the price to be created
     * @return ResponseEntity containing the created price DTO
     */
    @PostMapping
    public ResponseEntity<PriceDTO> create(@RequestBody PriceDTO priceDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(pricingUseCases.create(priceDTO));
    }

    /**
     * Retrieves all prices.
     *
     * @return ResponseEntity containing the list of all prices
     */
    @GetMapping
    public ResponseEntity<List<PriceDTO>> getAll() {
        return ResponseEntity.ok(pricingUseCases.getAll());
    }
}
