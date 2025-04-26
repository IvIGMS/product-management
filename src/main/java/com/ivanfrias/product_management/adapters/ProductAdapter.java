package com.ivanfrias.product_management.adapters;

import com.ivanfrias.product_management.clients.ProductClient;
import com.ivanfrias.product_management.clients.StoreClient;
import com.ivanfrias.product_management.exceptions.NotFoundException;
import com.ivanfrias.products.model.*;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductAdapter {
    private final ProductClient productClient;

    public List<ProductDTO> getProductsByStoreId(Long storeId){
        try {
            return productClient.getProductByStoreId(storeId).getBody();
        } catch (FeignException.FeignClientException e){
            throw new NotFoundException(e.getMessage());
        }
    }

    public List<CategoryDTO> getCategoriesById(Long storeId){
        try {
            return productClient.getCategoriesByStoreId(storeId).getBody();
        } catch (FeignException.FeignClientException e){
            throw new NotFoundException(e.getMessage());
        }
    }

    public ProductDTO createProduct(ProductRequestDTO productRequestDTO) {
        try {
            return productClient.createProduct(productRequestDTO).getBody();
        } catch (FeignException.FeignClientException e){
            throw new NotFoundException(e.getMessage());
        }
    }

    public CategoryDTO createCategory(CategoryRequestDTO categoryRequestDTO) {
        try {
            return productClient.createCategory(categoryRequestDTO).getBody();
        } catch (FeignException.FeignClientException e){
            throw new NotFoundException(e.getMessage());
        }
    }
}
