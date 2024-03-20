package org.demo.test.prices.infrastructure.web;

import org.demo.test.prices.application.dtos.PriceApplyingDTO;
import org.demo.test.prices.application.dtos.PriceCalculationDTO;
import org.demo.test.prices.domain.ports.in.PricingUseCases;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class PriceControllerTest {

    private PriceController priceController;

    @Mock
    private PricingUseCases pricingUseCases;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        priceController = new PriceController(pricingUseCases);
    }

    /**
     * Test 1: request at 10:00 a.m. on the 14th for product 35455 for brand 1 (XYZ)
     */
    @Test
    void testCalculatePrice_At_10AM_On_14th_For_Product_35455_Brand_1() {
        // Setup
        PriceApplyingDTO applyingDTO = PriceApplyingDTO.builder()
                .applicationDate(LocalDateTime.of(2024, 3, 14, 10, 0))
                .productId(35455L)
                .stringIdentifier("XYZ")
                .build();
        PriceCalculationDTO expectedDTO = createExpectedPriceCalculationDTO();
        when(pricingUseCases.calculate(applyingDTO)).thenReturn(expectedDTO);

        // Execute
        ResponseEntity<PriceCalculationDTO> response = priceController.calculate(applyingDTO);

        // Verify
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedDTO, response.getBody());
    }

    /**
     * Test 2: request at 4:00 p.m. on the 14th for product 35455 for brand 1 (XYZ)
     */
    @Test
    void testCalculatePrice_At_4PM_On_14th_For_Product_35455_Brand_1() {
        // Setup
        PriceApplyingDTO applyingDTO = PriceApplyingDTO.builder()
                .applicationDate(LocalDateTime.of(2024, 3, 14, 16, 0))
                .productId(35455L)
                .stringIdentifier("XYZ")
                .build();
        PriceCalculationDTO expectedDTO = createExpectedPriceCalculationDTO();
        // Adjust expected DTO as per Test 2 scenario
        expectedDTO.setRateToApply(2);
        when(pricingUseCases.calculate(applyingDTO)).thenReturn(expectedDTO);

        // Execute
        ResponseEntity<PriceCalculationDTO> response = priceController.calculate(applyingDTO);

        // Verify
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedDTO, response.getBody());
    }

    /**
     * Test 3: request at 9:00 p.m. on day 14th for product 35455 for brand 1 (XYZ)
     */
    @Test
    void testCalculatePrice_At_9PM_On_14th_For_Product_35455_Brand_1() {
        // Setup
        PriceApplyingDTO applyingDTO = PriceApplyingDTO.builder()
                .applicationDate(LocalDateTime.of(2024, 3, 14, 21, 0))
                .productId(35455L)
                .stringIdentifier("XYZ")
                .build();
        PriceCalculationDTO expectedDTO = createExpectedPriceCalculationDTO();
        // Adjust expected DTO as per Test 3 scenario
        expectedDTO.setRateToApply(2);
        when(pricingUseCases.calculate(applyingDTO)).thenReturn(expectedDTO);

        // Execute
        ResponseEntity<PriceCalculationDTO> response = priceController.calculate(applyingDTO);

        // Verify
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedDTO, response.getBody());
    }

    /**
     * Test 4: request at 10:00 a.m. on the 15th for product 35455 for brand 1 (XYZ)
     */
    @Test
    void testCalculatePrice_At_10AM_On_15th_For_Product_35455_Brand_1() {
        // Setup
        PriceApplyingDTO applyingDTO = PriceApplyingDTO.builder()
                .applicationDate(LocalDateTime.of(2024, 3, 15, 10, 0))
                .productId(35455L)
                .stringIdentifier("XYZ")
                .build();
        PriceCalculationDTO expectedDTO = createExpectedPriceCalculationDTO();
        // Adjust expected DTO as per Test 4 scenario
        expectedDTO.setStartDate(LocalDateTime.of(2020, 6, 15, 0, 0));
        expectedDTO.setEndDate(LocalDateTime.of(2020, 6, 15, 11, 0));
        expectedDTO.setRateToApply(3);
        expectedDTO.setFinalPrice(new BigDecimal("30.50"));
        when(pricingUseCases.calculate(applyingDTO)).thenReturn(expectedDTO);

        // Execute
        ResponseEntity<PriceCalculationDTO> response = priceController.calculate(applyingDTO);

        // Verify
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedDTO, response.getBody());
    }

    /**
     * Test 5: request at 9:00 p.m. on day 16th for product 35455 for brand 1 (XYZ)
     */
    @Test
    void testCalculatePrice_At_9PM_On_16th_For_Product_35455_Brand_1() {
        // Setup
        PriceApplyingDTO applyingDTO = PriceApplyingDTO.builder()
                .applicationDate(LocalDateTime.of(2024, 3, 16, 21, 0))
                .productId(35455L)
                .stringIdentifier("XYZ")
                .build();
        PriceCalculationDTO expectedDTO = createExpectedPriceCalculationDTO();
        // Adjust expected DTO as per Test 5 scenario
        expectedDTO.setStartDate(LocalDateTime.of(2020, 6, 15, 16, 0));
        expectedDTO.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
        expectedDTO.setRateToApply(4);
        expectedDTO.setFinalPrice(new BigDecimal("38.95"));
        when(pricingUseCases.calculate(applyingDTO)).thenReturn(expectedDTO);

        // Execute
        ResponseEntity<PriceCalculationDTO> response = priceController.calculate(applyingDTO);

        // Verify
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedDTO, response.getBody());
    }

    private PriceCalculationDTO createExpectedPriceCalculationDTO() {
        return PriceCalculationDTO.builder()
                .productId(35455L)
                .chainIdentifier("XYZ")
                .rateToApply(1)
                .startDate(LocalDateTime.of(2020, 6, 14, 0, 0))
                .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
                .finalPrice(new BigDecimal("35.50"))
                .currency("EUR")
                .build();
    }
}
