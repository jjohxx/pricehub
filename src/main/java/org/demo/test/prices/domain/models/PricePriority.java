package org.demo.test.prices.domain.models;

import lombok.Getter;

/**
 * Enumeration representing the priority of a price.
 */
@Getter
public enum PricePriority {
    /**
     * Low priority.
     */
    LOW(0),

    /**
     * Medium priority.
     */
    MEDIUM(1),

    /**
     * High priority.
     */
    HIGH(2);

    private final int value;

    PricePriority(int value) {
        this.value = value;
    }
}
