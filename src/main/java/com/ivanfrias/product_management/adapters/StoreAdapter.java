package com.ivanfrias.product_management.adapters;

import com.ivanfrias.product_management.clients.StoreClient;
import com.ivanfrias.product_management.exceptions.DataBaseErrorException;
import com.ivanfrias.product_management.exceptions.NotFoundException;
import com.ivanfrias.products.model.StoreDTO;
import com.ivanfrias.products.model.StoreRequestDTO;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
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

    public StoreDTO createStore(StoreRequestDTO storeRequestDTO){
        try {
            return storeClient.createStore(storeRequestDTO).getBody();
        } catch (FeignException.FeignClientException e){
            throw new DataBaseErrorException(e.getMessage());
        }
    }

    public void deleteStoreById(Long storeId){
        try {
            storeClient.deleteStoreById(storeId);
        } catch (FeignException.NotFound e){
            throw new NotFoundException(e.getMessage());
        } catch (FeignException.FeignClientException e){
            throw new DataBaseErrorException(e.getMessage());
        }
    }
}
