package com.restapi.gestion_bons.dto.commandefournisseur;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CommandeFournisseurRequestDTO extends BaseCommandeFournisseurDTO {

    @NotNull(message = "L'identifiant du fournisseur est obligatoire")
    private Long fournisseurId;

    @Builder.Default
    private List<LigneCommandeRequestDTO> lignesCommande = new ArrayList<>();

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class LigneCommandeRequestDTO {
        @NotNull(message = "L'identifiant du produit est obligatoire")
        private Long produitId;

        @NotNull(message = "La quantité commandée est obligatoire")
        @Positive(message = "La quantité commandée doit être positive")
        private Integer quantiteCommandee;

        @NotNull(message = "Le prix d'achat unitaire est obligatoire")
        @Positive(message = "Le prix d'achat unitaire doit être positif")
        private Double prixAchatUnitaire;
    }
}
