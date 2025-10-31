package com.restapi.gestion_bons.entitie;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "reference", unique = true)
    private String reference;

    @Column(name = "name", unique = true)
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @Column(name = "description")
    @Size(min = 2, max = 500, message = "Description must be between 2 and 500 characters")
    private String description;

    @Column(name = "unit_price")
    @Min(value = 0, message = "Unit price must be non-negative")
    private BigDecimal unitPrice;

    @Column(name = "category")
    @Size(min = 2, max = 100, message = "Category must be between 2 and 100 characters")
    private String category;

    @Column(name = "current_stock")
    @Min(value = 0, message = "Current stock must be non-negative")
    private Integer currentStock;

    @Column(name = "reorder_point")
    @Min(value = 0, message = "Reorder point must be non-negative")
    private Integer reorderPoint;

    @Column(name = "unit_of_measure")
    private String unitOfMeasure;
}