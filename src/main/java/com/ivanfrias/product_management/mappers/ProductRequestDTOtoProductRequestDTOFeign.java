package com.ivanfrias.product_management.mappers;

import com.ivanfrias.product_management.dto.ProductRequestDTOFeign;
import com.ivanfrias.products.model.ProductRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductRequestDTOtoProductRequestDTOFeign {
    ProductRequestDTOFeign productRequestDTOToProductRequestDTOFeign(ProductRequestDTO productRequestDTO);
}
