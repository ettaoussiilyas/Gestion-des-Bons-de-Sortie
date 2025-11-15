package com.restapi.gestion_bons.controller;

import com.restapi.gestion_bons.contracts.StockContract;
import com.restapi.gestion_bons.dto.mouvementstock.MouvementStockResponseDTO;
import com.restapi.gestion_bons.dto.stock.*;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/stock")
@RequiredArgsConstructor
public class StockController {

    private final StockContract stockService;

    @GetMapping
    public ResponseEntity<List<StockGlobalDTO>> getStockGlobal() {
        return ResponseEntity.ok(stockService.getStockGlobal());
    }

    @GetMapping("/produit/{id}")
    public ResponseEntity<StockProduitDetailDTO> getStockByProduitId(@PathVariable Long id) {
        return ResponseEntity.ok(stockService.getStockByProduitId(id));
    }

    @GetMapping("/mouvements")
    public ResponseEntity<List<MouvementStockResponseDTO>> getMouvements() {
        return ResponseEntity.ok(stockService.getMouvements());
    }

    @GetMapping("/mouvements/produit/{id}")
    public ResponseEntity<List<MouvementStockResponseDTO>> getMouvementsByProduitId(@PathVariable Long id) {
        return ResponseEntity.ok(stockService.getMouvementsByProduitId(id));
    }

    @GetMapping("/alertes")
    public ResponseEntity<List<StockAlertDTO>> getAlertes() {
        return ResponseEntity.ok(stockService.getAlertes());
    }

    @GetMapping("/valorisation")
    public ResponseEntity<StockValorisationDTO> getValorisation() {
        return ResponseEntity.ok(stockService.getValorisation());
    }

    @GetMapping("/search")
    public ResponseEntity<List<MouvementStockResponseDTO>> search(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String typeMouvement,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateMouvement,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDateMouvement,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDateMouvement,
            @RequestParam(required = false) Integer quantite,
            @RequestParam(required = false) Integer minQuantite,
            @RequestParam(required = false) Integer maxQuantite,
            @RequestParam(required = false) Double prixUnitaireLot,
            @RequestParam(required = false) Long produitId,
            @RequestParam(required = false) Long lotId,
            @RequestParam(required = false) Long bonDeSortieId
    ){
        if (dateMouvement != null && (startDateMouvement != null || endDateMouvement != null)) {
            throw new RuntimeException("on peus pas trouver une recherche avec une date spesific et une authre entre deux dates");
//            return ResponseEntity.badRequest().body(null);
        }

        if (quantite != null && (minQuantite != null || maxQuantite != null)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "on peus pas trouver une recherche avec une quantite spesific et une authre entre deux valeur"
            );
//            throw new RuntimeException("on peus pas trouver une recherche avec une quantite spesific et une authre entre deux valeur");
            //            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(stockService.search(
                id,
                typeMouvement,
                dateMouvement,
                startDateMouvement,
                endDateMouvement,
                quantite,
                minQuantite,
                maxQuantite,
                prixUnitaireLot,
                produitId,
                lotId,
                bonDeSortieId)
        );
    }
}
