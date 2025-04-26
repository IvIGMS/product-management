package com.ivanfrias.product_management.adapters;

import com.ivanfrias.product_management.clients.StoreClient;
import com.ivanfrias.product_management.exceptions.NotFoundException;
import com.ivanfrias.products.model.StoreDTO;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StoreAdapter {
    private final StoreClient storeClient;

    public StoreDTO getStoreById(Long storeId){
        try {
            return storeClient.getStoreById(storeId).getBody();
        } catch (FeignException.FeignClientException e){
            throw new NotFoundException(e.getMessage());
        }
    }
}
