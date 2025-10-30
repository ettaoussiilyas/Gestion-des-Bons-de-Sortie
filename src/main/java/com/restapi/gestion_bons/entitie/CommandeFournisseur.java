package com.restapi.gestion_bons.entitie;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "commande_fournisseur")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommandeFournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_commande", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateCommande;

    @Column(name = "montant_total", nullable = false)
    private Double montantTotal;

    @Column(name = "statut", nullable = false)
    @Enumerated(EnumType.STRING)
    private String statut;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fournisseur_id", nullable = false)
    private Fournisseur fournisseurId;

//    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<LigneCommande> lignesCommande;
//
//    @OneToMany(mappedBy = "commandeFournisseur", cascade = CascadeType.ALL)
//    private List<Lot> lots;

}
