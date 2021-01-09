package com.t_systems.sbb.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO <T extends Serializable> {
    T findById(final int id);

    List<T> findAll();

    void create(final T entity);

    void save(final T entity);

    void delete(final T entity);

    void deleteById(final int entityId);
}
