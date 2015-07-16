package com.cloudsherpas.poc.dao.impl;

import com.cloudsherpas.poc.dao.BaseDao;
import com.cloudsherpas.poc.dao.DaoManager;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;

import java.util.List;

public class BaseDaoImpl<T> implements BaseDao<T> {

    private Class<T> entityClass;

    private final DaoManager DAO_MANAGER = DaoManager.getInstance();

    public BaseDaoImpl(final Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T get(String key) {
        final Objectify ofy = DAO_MANAGER.getObjectify();
        return ofy.load().key(Key.create(entityClass, key)).now();
    }

    @Override
    public List<T> getAll() {
        final Objectify ofy = DAO_MANAGER.getObjectify();
        return ofy.load().type(entityClass).list();
    }

    @Override
    public void add(T entity) {
        final Objectify ofy = DAO_MANAGER.getObjectify();
        ofy.save().entity(entity);
    }

    @Override
    public void addAll(List<T> entities) {
        final Objectify ofy = DAO_MANAGER.getObjectify();
        ofy.save().entities(entities);
    }

    @Override
    public void update(T entity) {
        add(entity);
    }

    @Override
    public void updateAll(List<T> entities) {
        addAll(entities);
    }

    @Override
    public void delete(String key) {
        final Objectify ofy = DAO_MANAGER.getObjectify();
        ofy.delete().key(Key.create(entityClass, key));
    }
}
