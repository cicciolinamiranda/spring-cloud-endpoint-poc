package com.cloudsherpas.poc.service;

import com.cloudsherpas.poc.dao.ProductDao;
import com.cloudsherpas.poc.dao.impl.ProductDaoImpl;
import com.cloudsherpas.poc.dto.ProductDTO;
import com.cloudsherpas.poc.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    @Autowired
    @Qualifier("productDao")
    @Lazy
    private ProductDao productDao;

    private ModelMapper modelMapper;

    public ProductService() {
        productDao = new ProductDaoImpl();
        modelMapper = new ModelMapper();
    }

    public ProductDTO getProduct(final String key) {
        Product product = productDao.get(key);

        return modelMapper.map(product, ProductDTO.class);
    }

    public List<ProductDTO> getAllProducts() {
        List<Product> productList = productDao.getAll();
        List<ProductDTO> productDTOList = new ArrayList<>();

        for (Product product : productList) {
            productDTOList.add(modelMapper.map(product, ProductDTO.class));
        }

        return productDTOList;
    }

    public void addProduct(final ProductDTO productDTO) {
        productDao.add(modelMapper.map(productDTO, Product.class));
    }

    public void addProducts(final List<ProductDTO> productDTOList) {
        List<Product> productList = new ArrayList<>();

        for (ProductDTO productDTO : productDTOList) {
            productList.add(modelMapper.map(productDTO, Product.class));
        }

        productDao.addAll(productList);
    }

    public void updateProduct(final ProductDTO productDTO) {
        productDao.update(modelMapper.map(productDTO, Product.class));
    }

    public void updateAllProducts(final List<ProductDTO> productDTOList) {
        List<Product> productList = new ArrayList<>();

        for (ProductDTO productDTO : productDTOList) {
            productList.add(modelMapper.map(productDTO, Product.class));
        }

        productDao.updateAll(productList);
    }

    public void deleteProduct(final String key) {
        productDao.delete(key);
    }
}
