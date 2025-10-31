package com.restapi.gestion_bons.dto.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO {
    private Long id;

    @NotBlank(message = "reference is required")
    @Size(max = 100, message = "reference must be at most 100 characters")
    private String reference;

    @NotBlank(message = "name is required")
    @Size(min = 2, max = 100, message = "name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "description is required")
    @Size(min = 2, max = 500, message = "description must be between 2 and 500 characters")
    private String description;

    @NotNull(message = "unitPrice is required")
    @Min(value = 0, message = "unitPrice must be non-negative")
    private BigDecimal unitPrice;

    @NotBlank(message = "category is required")
    @Size(min = 2, max = 100, message = "category must be between 2 and 100 characters")
    private String category;

    @NotNull(message = "currentStock is required")
    @Min(value = 0, message = "currentStock must be non-negative")
    private Integer currentStock;

    @NotNull(message = "reorderPoint is required")
    @Min(value = 0, message = "reorderPoint must be non-negative")
    private Integer reorderPoint;

    @NotBlank(message = "unitOfMeasure is required")
    private String unitOfMeasure;
}
