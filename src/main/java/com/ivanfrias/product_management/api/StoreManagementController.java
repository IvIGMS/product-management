package com.ivanfrias.product_management.api;

import com.ivanfrias.product_management.api.utils.ControllerUtils;
import com.ivanfrias.product_management.exceptions.UnauthorizedException;
import com.ivanfrias.product_management.services.ProductService;
import com.ivanfrias.product_management.services.StoreService;
import com.ivanfrias.products.api.StoresApi;
import com.ivanfrias.products.model.StoreDTO;
import com.ivanfrias.products.model.StoreRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.ivanfrias.product_management.api.utils.ControllerUtilsConstants.STRING_NO_PREMISSIONS;

@RestController
@RequiredArgsConstructor
public class StoreManagementController extends ControllerUtils implements StoresApi {
    private final StoreService storeService;

    @Override
    public ResponseEntity<StoreDTO> createStore(StoreRequestDTO storeRequestDTO) {
        checkIsAdmin();
        return ResponseEntity.created(null).body(storeService.createStore(storeRequestDTO));
    }

    @Override
    public ResponseEntity<Void> deleteStoreById(Long storeId) {
        checkIsAdmin();
        storeService.deleteStoreById(storeId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<StoreDTO> getStoreById(Long storeId) {
        checkIsAdmin();
        return ResponseEntity.ok(storeService.getStoreById(storeId));
    }

    @Override
    public ResponseEntity<List<StoreDTO>> getStores() {
        checkIsAdmin();
        return ResponseEntity.ok(storeService.getStores());
    }
}
