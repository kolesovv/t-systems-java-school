package com.t_systems.sbb.service;

import java.io.Serializable;
import java.util.Collection;

public interface GenericService <T extends Serializable> {
    T findById(final long id);

    Collection<T> findAll();

    //void create(final T entity);

    void save(final T entity);

    //void delete(final T entity);

    void deleteById(final long entityId);
}
