package com.restapi.gestion_bons.dto.stocklot;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ResponseStockLotDTO extends RelationalStockLotDTO {
    // inherits relational fields from RelationalStockLotDTO
    private Long productId;
    private Long commandeFournisseurId;
}
