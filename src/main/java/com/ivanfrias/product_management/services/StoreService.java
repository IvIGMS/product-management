package com.ivanfrias.product_management.services;

import com.ivanfrias.product_management.adapters.ProductAdapter;
import com.ivanfrias.product_management.adapters.StoreAdapter;
import com.ivanfrias.products.model.ProductDTO;
import com.ivanfrias.products.model.ProductRequestDTO;
import com.ivanfrias.products.model.StoreDTO;
import com.ivanfrias.products.model.StoreRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreAdapter storeAdapter;

    public StoreDTO createStore(StoreRequestDTO storeRequestDTO) {
        return storeAdapter.createStore(storeRequestDTO);
    }

    public void deleteStoreById(Long storeId) {
        storeAdapter.deleteStoreById(storeId);
    }
}
