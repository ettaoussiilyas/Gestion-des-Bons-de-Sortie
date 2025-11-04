package com.restapi.gestion_bons.entitie;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.restapi.gestion_bons.entitie.enums.LotStatus;

@Entity
@Table(name = "lots")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** A unique code to identify each lot (e.g. LOT-2025-0012) */
    @Column(name = "numero_lot", nullable = false, unique = true)
    private String numeroLot;

    /** Date when the stock entered the warehouse */
    @Column(name = "date_entree", nullable = false)
    private LocalDateTime dateEntree;

    /** Quantity initially received */
    @NotNull
    @Min(0)
    @Column(name = "quantite_initiale", nullable = false)
    private Integer quantiteInitiale;

    /** Quantity currently available in this lot */
    @NotNull
    @Min(0)
    @Column(name = "quantite_restante", nullable = false)
    private Integer quantiteRestante;

    /** Purchase unit price for valuation (FIFO base) */
    @NotNull
    @Min(0)
    @Column(name = "prix_unitaire_achat", nullable = false, precision = 12, scale = 2)
    private BigDecimal prixUnitaireAchat;

    /** Link to the produit this lot belongs to */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produit_id", nullable = false)
    private Produit produit;

    /** Optional link to supplier order that created this lot */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commande_fournisseur_id")
    private CommandeFournisseur commandeFournisseur;

    /** Current status of the stock lot */
    @Enumerated(EnumType.STRING)
    @Column(name = "statut", nullable = false)
    private LotStatus statut;
}
