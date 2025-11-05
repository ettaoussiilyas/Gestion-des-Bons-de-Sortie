package com.restapi.gestion_bons.dto.commandefournisseur;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class CommandeFournisseurResponseDTO extends RelationalCommandeFournisseurDTO {
}
