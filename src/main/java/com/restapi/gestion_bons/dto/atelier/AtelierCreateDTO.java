package com.restapi.gestion_bons.dto.atelier;

import com.restapi.gestion_bons.entitie.BonDeSortie;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AtelierCreateDTO {

    private Long id;
    private String nom;
    private List<BonDeSortie> bonDeSorties;

}
