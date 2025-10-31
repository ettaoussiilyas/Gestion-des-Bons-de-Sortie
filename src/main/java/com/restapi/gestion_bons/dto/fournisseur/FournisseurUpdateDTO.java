package com.restapi.gestion_bons.dto.fournisseur;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FournisseurUpdateDTO {

    private Long id;
    private String raisonSociale;
    private String addressComplete;
    private String personneContact;
    private String email;
    private String telephone;
    private String ville;
    private String ice;
}
