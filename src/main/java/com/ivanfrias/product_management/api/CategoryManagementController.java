package com.ivanfrias.product_management.api;

import com.ivanfrias.product_management.api.utils.ControllerUtils;
import com.ivanfrias.product_management.services.CategoryService;
import com.ivanfrias.products.api.CategoriesApi;
import com.ivanfrias.products.model.CategoryDTO;
import com.ivanfrias.products.model.CategoryRequestDTO;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryManagementController extends ControllerUtils implements CategoriesApi {

    private final CategoryService categoryService;

    @Override
    public ResponseEntity<List<CategoryDTO>> getCategoriesByStoreId() {
        Claims claims = getAllClaims();
        Long storeId = ((Integer) claims.get("storeId")).longValue();
        return ResponseEntity.ok(categoryService.getCategoryByStoreId(storeId));
    }

    @Override
    public ResponseEntity<CategoryDTO> createCategory(CategoryRequestDTO categoryRequestDTO) {
        Claims claims = getAllClaims();
        Long storeId = ((Integer) claims.get("storeId")).longValue();
        return ResponseEntity.created(null).body(categoryService.createCategory(storeId, categoryRequestDTO));
    }
}
