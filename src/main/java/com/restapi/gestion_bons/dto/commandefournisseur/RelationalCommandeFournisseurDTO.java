package com.restapi.gestion_bons.dto.commandefournisseur;

import com.restapi.gestion_bons.dto.fournisseur.FournisseurResponseDTO;
import com.restapi.gestion_bons.dto.lignecommande.LigneCommandeResponseDTO;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class RelationalCommandeFournisseurDTO extends BaseCommandeFournisseurDTO {
    private FournisseurResponseDTO fournisseur;

    @Builder.Default
    private List<LigneCommandeResponseDTO> lignesCommande = new ArrayList<>();
}
