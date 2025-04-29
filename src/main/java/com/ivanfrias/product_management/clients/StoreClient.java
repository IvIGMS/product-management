package com.ivanfrias.product_management.clients;

import com.ivanfrias.product_management.security.FeignClientConfig;
import com.ivanfrias.products.model.StoreDTO;
import com.ivanfrias.products.model.StoreRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "Stores", url = "http://localhost:8081", configuration = FeignClientConfig.class)
public interface StoreClient {

    @GetMapping("/api/v1/stores/{storeId}")
    ResponseEntity<StoreDTO> getStoreById(@PathVariable("storeId") Long storeId);

    @PostMapping("/api/v1/stores")
    ResponseEntity<StoreDTO> createStore(StoreRequestDTO storeRequestDTO);

    @DeleteMapping("/api/v1/stores/{storeId}")
    void deleteStoreById(@PathVariable("storeId") Long storeId);

    @GetMapping("/api/v1/stores")
    ResponseEntity<List<StoreDTO>> getStores();
}
