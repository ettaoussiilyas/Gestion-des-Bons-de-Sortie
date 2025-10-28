package com.restapi.gestion_bons.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long id;
    private String reference;
    private String name;
    private String description;
    private BigDecimal unitPrice;
    private String category;
    private Integer currentStock;
    private Integer reorderPoint;
    private String unitOfMeasure;

}
