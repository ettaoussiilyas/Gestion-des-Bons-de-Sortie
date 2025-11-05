package com.restapi.gestion_bons.dto.lignecommande;

import com.restapi.gestion_bons.dto.produit.ProduitResponseDTO;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LigneCommandeResponseDTO {
    private Long id;
    private ProduitResponseDTO produit;
    private Integer quantiteCommandee;
    private Double prixAchatUnitaire;
}
