package com.restapi.gestion_bons.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FournisseurDTO {

    private Integer id;
    private String raisonSociale;
    private String addressComplete;
    private String personneContact;
    private String email;
    private String telephone;
    private String ville;
    private String ice;

}
