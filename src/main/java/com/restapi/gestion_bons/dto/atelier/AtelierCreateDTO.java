package com.restapi.gestion_bons.dto.atelier;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AtelierCreateDTO {

    private String nom;

}
