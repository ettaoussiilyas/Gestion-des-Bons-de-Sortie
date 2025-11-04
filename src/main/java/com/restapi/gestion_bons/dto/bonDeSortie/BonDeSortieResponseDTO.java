package com.restapi.gestion_bons.dto.bonDeSortie;


import com.restapi.gestion_bons.entitie.enums.BonDeSortieStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BonDeSortieResponseDTO {

    private Long id;
    private String numeroBon;
    private Date dateSortie;
    private String motifSortie;
    private BonDeSortieStatus statut;
    private Long atelier_destinataire_id;

}
