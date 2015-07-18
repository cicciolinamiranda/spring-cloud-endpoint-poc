package com.cloudsherpas.poc.dao.impl;

import com.cloudsherpas.poc.dao.BaseDao;
import com.cloudsherpas.poc.dao.DaoManager;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BaseDaoImpl<T> implements BaseDao<T> {

    private Class<T> entityClass;

    private final DaoManager DAO_MANAGER = DaoManager.getInstance();

    public BaseDaoImpl(final Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T get(final Long key) {
        final Objectify ofy = DAO_MANAGER.getObjectify();
        return ofy.load().type(entityClass).id(key).now();
    }

    @Override
    public List<T> getAll() {
        final Objectify ofy = DAO_MANAGER.getObjectify();
        return ofy.load().type(entityClass).list();
    }

    @Override
    public Long put(final T entity) {
        final Objectify ofy = DAO_MANAGER.getObjectify();
        return ofy.save().entity(entity).now().getId();
    }

    @Override
    public List<T> putAll(final List<T> entities) {
        final Objectify ofy = DAO_MANAGER.getObjectify();
        Map<Key<T>, T> result = ofy.save().entities(entities).now();

        return new ArrayList<>(result.values());
    }

    @Override
    public void delete(final Long key) {
        final Objectify ofy = DAO_MANAGER.getObjectify();
        ofy.delete().type(entityClass).id(key).now();
    }
}
