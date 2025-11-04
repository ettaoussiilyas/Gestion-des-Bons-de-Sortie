package com.restapi.gestion_bons.dto.Lot;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ResponseLotDTO extends RelationalLotDTO {
    // inherits relational fields from RelationalLotDTO
    private Long produitId;
    private Long commandeFournisseurId;
}
