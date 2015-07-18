package com.cloudsherpas.poc.dao;

import java.util.List;

public interface BaseDao<T> {

    T get(Long key);

    List<T> getAll();

    Long add(T entity);

    void addAll(List<T> entities);

    void update(T entity);

    void updateAll(List<T> entities);

    void delete(Long key);
}
