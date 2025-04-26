package com.ivanfrias.product_management.api;

import com.ivanfrias.product_management.services.CategoryService;
import com.ivanfrias.product_management.services.StoreService;
import com.ivanfrias.products.api.CategoriesApi;
import com.ivanfrias.products.api.ProductsApi;
import com.ivanfrias.products.model.CategoryDTO;
import com.ivanfrias.products.model.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryManagementController implements CategoriesApi {

    private final CategoryService categoryService;

    @Override
    public ResponseEntity<List<CategoryDTO>> getCategoriesByStoreId(Long storeId) {
        return ResponseEntity.ok(categoryService.getCategoryByStoreId(storeId));
    }
}
