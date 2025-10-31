package com.restapi.gestion_bons.entitie;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.restapi.gestion_bons.entitie.enums.LotStatus;

@Entity
@Table(name = "lots")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** A unique code to identify each lot (e.g. LOT-2025-0012) */
    @Column(name = "lot_number", nullable = false, unique = true)
    private String lotNumber;

    /** Date when the stock entered the warehouse */
    @Column(name = "entry_date", nullable = false)
    private LocalDateTime entryDate;

    /** Quantity initially received */
    @NotNull
    @Min(0)
    @Column(name = "initial_quantity", nullable = false)
    private Integer initialQuantity;

    /** Quantity currently available in this lot */
    @NotNull
    @Min(0)
    @Column(name = "remaining_quantity", nullable = false)
    private Integer remainingQuantity;

    /** Purchase unit price for valuation (FIFO base) */
    @NotNull
    @Min(0)
    @Column(name = "purchase_unit_price", nullable = false, precision = 12, scale = 2)
    private BigDecimal purchaseUnitPrice;

    /** Link to the product this lot belongs to */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    /** Optional link to supplier order that created this lot */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commande_fournisseur_id")
    private CommandeFournisseur commandeFournisseur;

    /** Current status of the stock lot */
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private LotStatus status;
}
