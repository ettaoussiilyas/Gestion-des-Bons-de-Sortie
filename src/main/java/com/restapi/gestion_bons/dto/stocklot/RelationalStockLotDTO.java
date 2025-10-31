package com.restapi.gestion_bons.dto.stocklot;

import com.restapi.gestion_bons.dao.CommandeFournisseurDAO;
import com.restapi.gestion_bons.dto.product.ProductResponseDTO;
import com.restapi.gestion_bons.entitie.CommandeFournisseur;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class RelationalStockLotDTO extends BaseStockLotDTO {
    // relation(s)
    private ProductResponseDTO product;
    private CommandeFournisseur commandeFournisseur;
}
