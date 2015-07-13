package com.cloudsherpas.poc.dao;

import java.util.List;

public interface BaseDao<E> {

    E get(String key);
    List<E> getAll();
    void add(E entity);
    void addAll(List<E> entities);
    void update(E entity);
    void updateAll(List<E> entities);
    void delete(String key);
    void deleteAll(List<String> keys);

}
