package com.ivanfrias.product_management.clients;

import com.ivanfrias.products.model.StoreDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Stores", url = "http://localhost:8081")
public interface StoreClient {

    @GetMapping("/api/v1/stores/{storeId}")
    ResponseEntity<StoreDTO> getStoreById(@PathVariable("storeId") Long storeId);
}
