package com.restapi.gestion_bons.controller;

import com.restapi.gestion_bons.contracts.StockContract;
import com.restapi.gestion_bons.dto.mouvementstock.MouvementStockResponseDTO;
import com.restapi.gestion_bons.dto.stock.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
