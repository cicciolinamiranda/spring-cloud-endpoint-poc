package com.cloudsherpas.poc.api;

import com.cloudsherpas.poc.dto.ProductDTO;
import com.cloudsherpas.poc.model.Product;
import com.cloudsherpas.poc.service.ProductService;
import com.cloudsherpas.poc.util.JsonConversionUtility;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.google.appengine.repackaged.com.google.api.client.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;

import java.util.List;

@Api(
        name = "poc",
        version = "1"
)
public class ProductResource {

    @Autowired
    @Qualifier("productService")
    @Lazy
    private ProductService productService;

    @ApiMethod(
            name = "getProduct",
            path = "product",
            httpMethod = ApiMethod.HttpMethod.GET
    )
    public ProductDTO getProduct(@Named("productKey") final String key) {
        return productService.getProduct(key);
    }

    @ApiMethod(
            name = "getAllProducts",
            path = "products/all",
            httpMethod = ApiMethod.HttpMethod.GET
    )
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @ApiMethod(
            name = "addProduct",
            path = "product",
            httpMethod = ApiMethod.HttpMethod.POST
    )
    public void addProduct(final ProductDTO productDTO) {
        productService.addProduct(productDTO);
    }

    @ApiMethod(
            name = "addProducts",
            path = "products",
            httpMethod = ApiMethod.HttpMethod.POST
    )
    public void addProducts(final String requestJson) {
        final List<ProductDTO> productDTOList = JsonConversionUtility.convertJsonToObject(requestJson,
                new TypeReference<List<ProductDTO>>() {
                });

        productService.addProducts(productDTOList);
    }

    @ApiMethod(
            name = "updateProduct",
            path = "product",
            httpMethod = ApiMethod.HttpMethod.PUT
    )
    public void updateProduct(final ProductDTO productDTO) {
        productService.updateProduct(productDTO);
    }

    @ApiMethod(
            name = "updateAllProducts",
            path = "products/all",
            httpMethod = ApiMethod.HttpMethod.PUT
    )
    public void updateAllProducts(final String requestJson) {
        final List<ProductDTO> productDTOList = JsonConversionUtility.convertJsonToObject(requestJson,
                new TypeReference<List<ProductDTO>>() {
                });

        productService.updateAllProducts(productDTOList);
    }

    @ApiMethod(
            name = "deleteProduct",
            path = "product",
            httpMethod = ApiMethod.HttpMethod.DELETE
    )
    public void deleteProduct(@Named("key") final String key) {
        productService.deleteProduct(key);
    }
}
