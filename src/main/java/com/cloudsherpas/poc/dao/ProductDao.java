package com.cloudsherpas.poc.dao;

import com.cloudsherpas.poc.model.Product;

public interface ProductDao extends BaseDao<Product> {

    void increaseStock(String key, int quantity);
    void decreaseStock(String key, int quantity);
}
