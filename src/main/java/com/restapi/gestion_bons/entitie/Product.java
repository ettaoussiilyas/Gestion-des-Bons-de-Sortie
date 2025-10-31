package com.restapi.gestion_bons.entitie;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
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

    @Column(name = "category")
    @Size(min = 2, max = 100, message = "Category must be between 2 and 100 characters")
    private String category;

    @Column(name = "unit_of_measure")
    private String unitOfMeasure;

    @OneToMany(mappedBy = "produit", fetch = FetchType.LAZY)
    private List<LigneCommande> lignesCommande = new ArrayList<>();

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Lot> lots = new ArrayList<>();

}