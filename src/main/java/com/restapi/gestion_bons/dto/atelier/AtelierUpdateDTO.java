package com.restapi.gestion_bons.dto.atelier;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AtelierUpdateDTO {

    private String nom;

}
