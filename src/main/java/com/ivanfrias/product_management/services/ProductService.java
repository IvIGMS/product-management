package com.ivanfrias.product_management.services;

import com.ivanfrias.product_management.adapters.ProductAdapter;
import com.ivanfrias.product_management.adapters.StoreAdapter;
import com.ivanfrias.products.model.PagedResponseProductDTO;
import com.ivanfrias.products.model.ProductDTO;
import com.ivanfrias.products.model.ProductRequestDTO;
import com.ivanfrias.products.model.StoreDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final StoreAdapter storeAdapter;
    private final ProductAdapter productAdapter;

    public List<ProductDTO> getProductsFilter(String productName, String categoryName, Double minPrice, Double maxPrice, Long storeId) {
        if(Objects.nonNull(storeId)) {
            storeAdapter.getStoreById(storeId); // Si no la encuentra da un 404.
        }
        return productAdapter.getProductsFilter(productName, categoryName, minPrice, maxPrice, storeId);
    }

    public ProductDTO createProduct(Long storeId, ProductRequestDTO productRequestDTO) {
        return null;
    }

    public PagedResponseProductDTO getPagedProductsFilter(
            String productName,
            String categoryName,
            Double minPrice,
            Double maxPrice,
            Long storeId,
            Integer pageNumberQueryParam,
            Integer pageSizeQueryParam,
            String sortByQueryParam
    ) {
        return productAdapter.getPagedProductsFilter(productName, categoryName, minPrice, maxPrice, storeId, pageNumberQueryParam, pageSizeQueryParam, sortByQueryParam);
    }
}
