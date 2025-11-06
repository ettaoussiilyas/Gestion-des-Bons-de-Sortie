package com.restapi.gestion_bons.dto.commandefournisseur;


import com.restapi.gestion_bons.entitie.Fournisseur;
import com.restapi.gestion_bons.entitie.enums.CommandeStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CommandeFournisseurCreateDTO {

    private Long id;
    private Date dateCommande;
    private Double montantTotal;
    private CommandeStatus statut;
    private Long fournisseurId;

}
