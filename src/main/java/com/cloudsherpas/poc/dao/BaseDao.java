package com.cloudsherpas.poc.dao;

import java.util.List;

public interface BaseDao<E> {

    public E get(String key);
    public List<E> getAll();
    public void add(E entity);
    public void addAll(List<E> entities);
    public void update(E entity);
    public void updateAll(List<E> entities);
    public void delete(String key);
    public void deleteAll(List<String> keys);

}
