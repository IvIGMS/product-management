package com.ivanfrias.product_management.services;

import com.ivanfrias.product_management.adapters.ProductAdapter;
import com.ivanfrias.product_management.adapters.StoreAdapter;
import com.ivanfrias.products.model.ProductDTO;
import com.ivanfrias.products.model.StoreDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreAdapter storeAdapter;
    private final ProductAdapter productAdapter;

    public List<ProductDTO> getProductsByStoreId(Long storeId) {
        StoreDTO storeDTO = storeAdapter.getStoreById(storeId);
        return productAdapter.getProductsByStoreId(storeDTO.getId());
    }
}
