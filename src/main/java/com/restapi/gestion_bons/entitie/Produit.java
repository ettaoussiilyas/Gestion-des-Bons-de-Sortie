package com.restapi.gestion_bons.entitie;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "produit")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Produit {

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

    @Column(name = "prix_unitaire", nullable = false)
    private Double unitPrice;

    @Column(name = "category")
    @Size(min = 2, max = 100, message = "Category must be between 2 and 100 characters")
    private String category;

    @Column(name = "stock_actuel")
    private Integer stockActuel;

    @Column(name = "point_de_commande")
    private Integer commandePoint;

    @Column(name = "unit_of_measure")
    private String unitOfMeasure;

    @OneToMany(mappedBy = "produit", fetch = FetchType.LAZY)
    @Builder.Default
    private List<LigneCommande> lignesCommande = new ArrayList<>();

    @OneToMany(mappedBy = "produit", fetch = FetchType.LAZY)
    @Builder.Default
    private List<Lot> lots = new ArrayList<>();

    @OneToMany(mappedBy = "produit", fetch = FetchType.LAZY)
    @Builder.Default
    private List<MouvementStock> mouvementsStocks = new ArrayList<>();

    @OneToMany(mappedBy = "produit", fetch = FetchType.LAZY)
    @Builder.Default
    private List<BonDeSortieLigne> bonDeSortieLignes = new ArrayList<>();

    @OneToMany(mappedBy = "produit")
    @Builder.Default
    private List<MouvementStock> mouvements = new ArrayList<>();

}