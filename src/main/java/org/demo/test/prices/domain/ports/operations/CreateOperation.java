package org.demo.test.prices.domain.ports.operations;

/**
 * Interface representing a create operation.
 *
 * @param <T> The type of entity to be created
 */
@FunctionalInterface
public interface CreateOperation<T> {

    /**
     * Creates an entity.
     *
     * @param entity The entity to be created
     * @return The created entity
     */
    T create(T entity);
}
