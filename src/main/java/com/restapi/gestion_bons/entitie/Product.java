package com.restapi.gestion_bons.entitie;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "reference")
    private String reference;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "category")
    private String category;

    @Column(name = "current_stock")
    private Integer currentStock;

    @Column(name = "reorder_point")
    private Integer reorderPoint;

    @Column(name = "unit_of_measure")
    private String unitOfMeasure;

    @Entity
    @Table(name = "fournisseur")
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @EqualsAndHashCode(onlyExplicitlyIncluded = true)
    public static class Fournisseur {

        @Id
        @EqualsAndHashCode.Include
        private Integer id;

        @Column(name = "raison_social", nullable = false)
        private String raisonSociale;

        @Column(name = "address_complete", nullable = false)
        private String addressComplete;

        @Column(name = "personne_contact")
        private String personneContact;

        @Column(unique = true, nullable = false)
        private String email;

        @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$")
        private String telephone;

        private String ville;

        private String ice;

    }
}
