package com.restapi.gestion_bons.dto.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO {
    private String id;
    private String reference;
    private String name;
    private String description;
    private BigDecimal unitPrice;
    private String category;
    private Integer currentStock;
    private Integer reorderPoint;
    private String unitOfMeasure;
}
