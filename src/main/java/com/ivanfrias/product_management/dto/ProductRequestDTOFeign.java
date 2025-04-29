package com.ivanfrias.product_management.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTOFeign {
    private String productName;
    private BigDecimal price;
    private Long categoryId;
    private Long storeId;
}