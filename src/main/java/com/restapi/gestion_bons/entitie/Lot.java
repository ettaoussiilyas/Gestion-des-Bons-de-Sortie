package com.restapi.gestion_bons.entitie;


import jakarta.persistence.*;
import lombok.*;

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
    private Integer id;

    @Column(name = "numero_lot", nullable = false)
    private String numeroLot;

    @Column(name = "date_entree", nullable = false)
    @Enumerated(EnumType.STRING)
    private Date dateEntree;

    @Column(name= "quantite_initiale", nullable= false)
    private Integer quantiteIntiale;

    @Column(name= "quantite_restante", nullable= false)
    private Integer quantiteRestante;

    @Column(name = "prix_achat_unitaire", nullable = false)
    private Integer prixAchatUnitaire;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produit_id", nullable = false)
    private Product produit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commande_fournisseur_id", nullable = false)
    private CommandeFournisseur commandeFournisseur;
}
