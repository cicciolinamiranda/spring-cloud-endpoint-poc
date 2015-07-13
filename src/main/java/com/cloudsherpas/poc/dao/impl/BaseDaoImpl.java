package com.cloudsherpas.poc.dao.impl;

import com.cloudsherpas.poc.dao.BaseDao;

import java.util.List;

public class BaseDaoImpl<E> implements BaseDao<E> {

    @Override
    public E get(String key) {
        return null;
    }

    @Override
    public List<E> getAll() {
        return null;
    }

    @Override
    public void add(E entity) {

    }

    @Override
    public void addAll(List<E> entities) {

    }

    @Override
    public void update(E entity) {

    }

    @Override
    public void updateAll(List<E> entities) {

    }

    @Override
    public void delete(String key) {

    }

    @Override
    public void deleteAll(List<String> keys) {

    }
}
