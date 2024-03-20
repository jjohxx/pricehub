package org.demo.test.prices.domain.ports.operations;

/**
 * Interface representing a calculation operation.
 *
 * @param <T> The type of request input for the calculation
 * @param <E> The type of result produced by the calculation
 */
@FunctionalInterface
public interface CalculateOperation<T, E> {

    /**
     * Performs a calculation operation based on the provided request.
     *
     * @param request The input request for the calculation
     * @return The result produced by the calculation
     */
    E calculate(T request);
}
