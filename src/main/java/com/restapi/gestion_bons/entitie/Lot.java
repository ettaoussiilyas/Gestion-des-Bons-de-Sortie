package com.restapi.gestion_bons.entitie;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "lot")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "numero_lot", nullable = false, unique = true)
    private String numeroLot;

    @NotNull
    @PastOrPresent
    @Column(name = "date_entree", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEntree;

    @NotNull
    @PositiveOrZero
    @Column(name = "quantite_initiale", nullable = false)
    private Integer quantiteInitiale;

    @NotNull
    @PositiveOrZero
    @Column(name = "quantite_restante", nullable = false)
    private Integer quantiteRestante;

    @NotNull
    @PositiveOrZero
    @Column(name = "prix_achat_unitaire", nullable = false)
    private BigDecimal prixAchatUnitaire;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produit_id", nullable = false)
    private Product produit;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commande_fournisseur_id", nullable = false)
    private CommandeFournisseur commandeFournisseur;
}