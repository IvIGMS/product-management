package com.ivanfrias.product_management.api;

import com.ivanfrias.product_management.exceptions.NotFoundException;
import com.ivanfrias.product_management.exceptions.UnauthorizedException;
import com.ivanfrias.products.model.PagedResponseProductDTO;
import io.jsonwebtoken.Claims;

import com.ivanfrias.product_management.api.utils.ControllerUtils;
import com.ivanfrias.product_management.services.ProductService;
import com.ivanfrias.products.api.ProductsApi;
import com.ivanfrias.products.model.ProductDTO;
import com.ivanfrias.products.model.ProductRequestDTO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

import static com.ivanfrias.product_management.api.utils.ControllerUtilsConstants.STRING_NO_PREMISSIONS;

@RestController
@RequiredArgsConstructor
public class ProductManagementController extends ControllerUtils implements ProductsApi {
    private final ProductService productService;
    private final HttpServletRequest request;


    @Override
    public ResponseEntity<List<ProductDTO>> getProducts(String productName, String categoryName, Double minPrice, Double maxPrice, Long storeId) {
        if(checkIsManager()){
            Claims claims = getAllClaims();
            storeId = ((Integer) claims.get("storeId")).longValue();
        }
        return ResponseEntity.ok(productService.getProductsFilter(productName, categoryName, minPrice, maxPrice, storeId));
    }

    @Override
    public ResponseEntity<ProductDTO> createProduct(ProductRequestDTO productRequestDTO) {
        if(checkIsManager()){
            Claims claims = getAllClaims();
            productRequestDTO.setStoreId(((Integer) claims.get("storeId")).longValue());
        }
        Claims claims = getAllClaims();
        Long storeId = ((Integer) claims.get("storeId")).longValue();
        return ResponseEntity.created(null).body(productService.createProduct(storeId, productRequestDTO));
    }

    @Override
    public ResponseEntity<PagedResponseProductDTO> getPagedProductsFilter(
            String productName,
            String categoryName,
            Double minPrice,
            Double maxPrice,
            Long storeId,
            Integer pageNumberQueryParam,
            Integer pageSizeQueryParam,
            String sortByQueryParam
    ) {
        if(checkIsManager()){
            Claims claims = getAllClaims();
            storeId = ((Integer) claims.get("storeId")).longValue();
        }

        PagedResponseProductDTO pagedResponseProductDTO = productService.getPagedProductsFilter(
                productName, categoryName, minPrice, maxPrice, storeId, pageNumberQueryParam, pageSizeQueryParam, sortByQueryParam
        );

        return ResponseEntity.ok(pagedResponseProductDTO);
    }
}
