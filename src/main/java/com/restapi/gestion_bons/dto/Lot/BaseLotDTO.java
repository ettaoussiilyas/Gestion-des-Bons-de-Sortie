package com.restapi.gestion_bons.dto.Lot;

import lombok.*;
import lombok.experimental.SuperBuilder;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.restapi.gestion_bons.entitie.enums.LotStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BaseLotDTO {
    // non-relational properties only
    private Long id;
    private String lotNumber;
    private Long productId;
    private LocalDateTime entryDate;
    private Integer initialQuantity;
    private Integer remainingQuantity;
    private BigDecimal purchaseUnitPrice;
    private LotStatus status;
}
