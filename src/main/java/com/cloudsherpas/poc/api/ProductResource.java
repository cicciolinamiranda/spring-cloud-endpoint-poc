package com.cloudsherpas.poc.api;

import com.cloudsherpas.poc.dto.ProductDTO;
import com.cloudsherpas.poc.service.ProductService;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;

import java.util.List;

@Api(
        name = "poc",
        version = "1"
)
public class ProductResource {
    private ProductService productService;

    public ProductResource() {
        productService = new ProductService();
    }

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
            httpMethod = ApiMethod.HttpMethod.POST
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
    public void addProducts(final List<ProductDTO> productDTOList) {
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
    public void updateAllProducts(final List<ProductDTO> productDTOList) {
        productService.updateAllProducts(productDTOList);
    }


    @ApiMethod(
            name = "deleteProduct",
            path = "product",
            httpMethod = ApiMethod.HttpMethod.DELETE
    )
    public void deleteProduct(final String key) {
       productService.deleteProduct(key);
    }
}
