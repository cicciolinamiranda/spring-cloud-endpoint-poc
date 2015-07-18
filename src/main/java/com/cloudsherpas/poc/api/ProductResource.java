package com.cloudsherpas.poc.api;

import com.cloudsherpas.poc.dto.ProductDTO;
import com.cloudsherpas.poc.dto.ProductListDTO;
import com.cloudsherpas.poc.service.ProductService;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ProductDTO getProduct(@Named("id") final Long key) {
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
            name = "addUpdateProduct",
            path = "product",
            httpMethod = ApiMethod.HttpMethod.PUT
    )
    public Map<String, Long> addProduct(final ProductDTO productDTO) {
        final Long key = productService.addUpdateProduct(productDTO);
        final Map<String, Long> result = new HashMap<>();

        if (key != null){
            result.put("key", key);
        }

        return result;
    }

    @ApiMethod(
            name = "addUpdateProducts",
            path = "products",
            httpMethod = ApiMethod.HttpMethod.PUT
    )
    public List<ProductDTO> addProducts(final ProductListDTO productList) {
        return productService.addUpdateProducts(productList.getItems());
    }

    @ApiMethod(
            name = "deleteProduct",
            path = "product",
            httpMethod = ApiMethod.HttpMethod.DELETE
    )
    public void deleteProduct(@Named("id") final Long key) {
        productService.deleteProduct(key);
    }
}
