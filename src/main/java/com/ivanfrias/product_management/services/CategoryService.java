package com.ivanfrias.product_management.services;

import com.ivanfrias.product_management.adapters.ProductAdapter;
import com.ivanfrias.product_management.adapters.StoreAdapter;
import com.ivanfrias.products.model.CategoryDTO;
import com.ivanfrias.products.model.ProductDTO;
import com.ivanfrias.products.model.StoreDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final StoreAdapter storeAdapter;
    private final ProductAdapter productAdapter;

    public List<CategoryDTO> getCategoryByStoreId(Long storeId) {
        StoreDTO storeDTO = storeAdapter.getStoreById(storeId);
        return productAdapter.getCategoriesById(storeDTO.getId());
    }
}
