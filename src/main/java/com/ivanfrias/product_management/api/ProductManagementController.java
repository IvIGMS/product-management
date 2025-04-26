package com.ivanfrias.product_management.api;

import com.ivanfrias.product_management.services.StoreService;
import com.ivanfrias.products.api.ProductsApi;
import com.ivanfrias.products.model.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductManagementController implements ProductsApi {

    private final StoreService storeService;

    @Override
    public ResponseEntity<List<ProductDTO>> getProductsByStoreId(Long storeId) {
        return ResponseEntity.ok(storeService.getProductsByStoreId(storeId));
    }
}
