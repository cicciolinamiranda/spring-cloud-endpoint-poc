package com.cloudsherpas.poc.dao.impl;

import com.cloudsherpas.poc.dao.BaseDao;
import com.cloudsherpas.poc.dao.DaoManager;
import com.googlecode.objectify.Objectify;

import java.util.List;

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
    public Long add(final T entity) {
        final Objectify ofy = DAO_MANAGER.getObjectify();
        return ofy.save().entity(entity).now().getId();
    }

    @Override
    public void addAll(final List<T> entities) {
        final Objectify ofy = DAO_MANAGER.getObjectify();
        ofy.save().entities(entities);
    }

    @Override
    public void update(final T entity) {
        add(entity);
    }

    @Override
    public void updateAll(final List<T> entities) {
        addAll(entities);
    }

    @Override
    public void delete(final Long key) {
        final Objectify ofy = DAO_MANAGER.getObjectify();
        ofy.delete().type(entityClass).id(key).now();
    }
}
