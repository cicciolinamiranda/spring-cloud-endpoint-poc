package com.cloudsherpas.poc.dao;

import java.util.List;

public interface BaseDao<T> {

    T get(Long key);

    List<T> getAll();

    Long put(T entity);

    List<T> putAll(List<T> entities);

    void delete(Long key);
}
