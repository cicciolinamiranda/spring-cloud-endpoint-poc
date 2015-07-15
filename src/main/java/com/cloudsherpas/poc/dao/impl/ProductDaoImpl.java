package com.cloudsherpas.poc.dao.impl;

import com.cloudsherpas.poc.dao.DaoManager;
import com.cloudsherpas.poc.dao.ProductDao;
import com.cloudsherpas.poc.model.Product;
import com.googlecode.objectify.Objectify;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao {

    private static final DaoManager DAO_MANAGER = DaoManager.getInstance();

    @Override
    public List<Product> getAll() {
        final Objectify ofy = DAO_MANAGER.getObjectify();
        return ofy.load().type(Product.class).list();
    }

    @Override
    public void increaseStock(String key, int quantity) {
        final Product product = get(key);
        product.setStock(product.getStock() + quantity);
    }

    @Override
    public void decreaseStock(String key, int quantity) {
        final Product product = get(key);
        product.setStock(product.getStock() - quantity);
    }
}
