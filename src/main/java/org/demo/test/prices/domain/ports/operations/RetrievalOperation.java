package org.demo.test.prices.domain.ports.operations;

import java.util.List;

/**
 * Interface representing basic retrieval operations for all entities.
 *
 * @param <T> The type of entity being retrieved
 */
public interface RetrievalOperation<T> {

    /**
     * Retrieves all entities.
     *
     * @return A list containing all entities
     */
    List<T> getAll();

    /**
     * Retrieves an entity by its identifier.
     *
     * @param id The identifier of the entity to retrieve
     * @return The retrieved entity
     */
    T getById(Long id);
}

