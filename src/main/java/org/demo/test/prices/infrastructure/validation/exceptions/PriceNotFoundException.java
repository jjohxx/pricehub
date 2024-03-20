package org.demo.test.prices.infrastructure.validation.exceptions;

/**
 * Exception representing the absence of prices for a product.
 */
public class PriceNotFoundException extends RuntimeException {

    /**
     * The format of the message for price not found exception.
     */
    private static final String PRICE_NOT_FOUND_MESSAGE_FORMAT = "No applicable prices were found "
            + "for the product with ID: %d";

    /**
     * Constructs a new PriceNotFoundException with the specified product ID.
     *
     * @param productId The identifier of the product for which prices were not found
     */
    public PriceNotFoundException(Long productId) {
        this(String.format(PRICE_NOT_FOUND_MESSAGE_FORMAT, productId));
    }

    /**
     * Constructs a new PriceNotFoundException with the specified message.
     *
     * @param message The detail message associated with the exception
     */
    public PriceNotFoundException(String message) {
        super(message);
    }
}

