package com.ivanfrias.product_management.clients;

import com.ivanfrias.product_management.security.FeignClientConfig;
import com.ivanfrias.products.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "Products", url = "http://localhost:8083", configuration = FeignClientConfig.class)
public interface ProductClient {

    @GetMapping("/api/v1/products")
    ResponseEntity<List<ProductDTO>> getProductFilter(
            @RequestParam(name = "productName", required = false) String productName,
            @RequestParam(name = "categoryName", required = false) String categoryName,
            @RequestParam(name = "minPrice", required = false) Double minPrice,
            @RequestParam(name = "maxPrice", required = false) Double maxPrice,
            @RequestParam(name = "storeId", required = false) Long storeId
    );

    @GetMapping("/api/v1/categories/{storeId}/stores")
    ResponseEntity<List<CategoryDTO>> getCategoriesByStoreId(@PathVariable("storeId") Long storeId);

    @PostMapping("/api/v1/products")
    ResponseEntity<ProductDTO> createProduct(@RequestBody ProductRequestDTO productRequestDTO);

    @PostMapping("/api/v1/categories")
    ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryRequestDTO categoryRequestDTO);

    @GetMapping("/api/v1/products/paged")
    ResponseEntity<PagedResponseProductDTO> getPagedProductsFilter(
            @RequestParam(name = "productName", required = false) String productName,
            @RequestParam(name = "categoryName", required = false) String categoryName,
            @RequestParam(name = "minPrice", required = false) Double minPrice,
            @RequestParam(name = "maxPrice", required = false) Double maxPrice,
            @RequestParam(name = "storeId", required = false) Long storeId,
            @RequestParam(name = "pageNumberQueryParam", required = false) Integer pageNumberQueryParam,
            @RequestParam(name = "pageSizeQueryParam", required = false) Integer pageSizeQueryParam,
            @RequestParam(name = "sortByQueryParam", required = false) String sortByQueryParam
    );

}
