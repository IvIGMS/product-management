package com.ivanfrias.product_management.api;

import io.jsonwebtoken.Claims;

import com.ivanfrias.product_management.api.utils.ControllerUtils;
import com.ivanfrias.product_management.security.JwtService;
import com.ivanfrias.product_management.services.ProductService;
import com.ivanfrias.products.api.ProductsApi;
import com.ivanfrias.products.model.ProductDTO;
import com.ivanfrias.products.model.ProductRequestDTO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductManagementController extends ControllerUtils implements ProductsApi {
    private final ProductService productService;
    private final HttpServletRequest request;

    @Override
    public ResponseEntity<List<ProductDTO>> getProductsByStoreId(Long storeId) {
        String authorizationHeader = getToken();
        Claims claims = getAllClaims();
        return ResponseEntity.ok(productService.getProductsByStoreId(storeId));
    }

    @Override
    public ResponseEntity<ProductDTO> createProduct(Long storeId, ProductRequestDTO productRequestDTO) {
        return ResponseEntity.created(null).body(productService.createProduct(storeId, productRequestDTO));
    }
}
