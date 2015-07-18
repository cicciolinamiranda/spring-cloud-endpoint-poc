package com.cloudsherpas.poc.dao;

import com.cloudsherpas.poc.model.Product;

public interface ProductDao extends BaseDao<Product> {

    void increaseStock(Long key, int quantity);

    void decreaseStock(Long key, int quantity);
}
