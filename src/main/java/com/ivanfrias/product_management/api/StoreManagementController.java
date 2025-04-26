package com.ivanfrias.product_management.api;

import com.ivanfrias.product_management.services.ProductService;
import com.ivanfrias.product_management.services.StoreService;
import com.ivanfrias.products.api.StoresApi;
import com.ivanfrias.products.model.StoreDTO;
import com.ivanfrias.products.model.StoreRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StoreManagementController implements StoresApi {
    private final StoreService storeService;

    @Override
    public ResponseEntity<StoreDTO> createStore(StoreRequestDTO storeRequestDTO) {
        return ResponseEntity.created(null).body(storeService.createStore(storeRequestDTO));
    }

    @Override
    public ResponseEntity<Void> deleteStoreById(Long storeId) {
        storeService.deleteStoreById(storeId);
        return ResponseEntity.noContent().build();
    }
}
