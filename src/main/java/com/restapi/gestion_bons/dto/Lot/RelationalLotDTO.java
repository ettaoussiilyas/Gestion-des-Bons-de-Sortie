package com.restapi.gestion_bons.dto.Lot;

import com.restapi.gestion_bons.dto.product.ProductResponseDTO;
import com.restapi.gestion_bons.entitie.CommandeFournisseur;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class RelationalLotDTO extends BaseLotDTO {

    private ProductResponseDTO produit;
    private CommandeFournisseur commandeFournisseur;
}
