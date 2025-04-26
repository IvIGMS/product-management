package com.ivanfrias.product_management.clients;

import com.ivanfrias.products.model.CategoryDTO;
import com.ivanfrias.products.model.ProductDTO;
import com.ivanfrias.products.model.StoreDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "Products", url = "http://localhost:8083")
public interface ProductClient {

    @GetMapping("/api/v1/products/{storeId}/stores")
    ResponseEntity<List<ProductDTO>> getProductByStoreId(@PathVariable("storeId") Long storeId);

    @GetMapping("/api/v1/categories/{storeId}/stores")
    ResponseEntity<List<CategoryDTO>> getCategoriesByStoreId(@PathVariable("storeId") Long storeId);
}
