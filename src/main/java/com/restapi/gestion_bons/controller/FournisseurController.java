package com.restapi.gestion_bons.controller;

import com.restapi.gestion_bons.dto.FournisseurDTO;
import com.restapi.gestion_bons.service.FournisseurService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/fournisseurs")
public class FournisseurController {

    private final FournisseurService fournisseurService;

    public FournisseurController(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    @GetMapping
    public ResponseEntity<List<FournisseurDTO>> listAll() {
        return ResponseEntity.ok(fournisseurService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FournisseurDTO> getFournisseurById(@PathVariable Integer id) {
        return ResponseEntity.ok(fournisseurService.findById(id));
    }

    @PostMapping
    public ResponseEntity<FournisseurDTO> createFournisseur(@Valid @RequestBody FournisseurDTO fournisseurDTO) {
        FournisseurDTO created = fournisseurService.save(fournisseurDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FournisseurDTO> updateFournisseur(
            @PathVariable Integer id,
            @Valid @RequestBody FournisseurDTO fournisseurDTO) {
        return ResponseEntity.ok(fournisseurService.update(id, fournisseurDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFournisseur(@PathVariable Integer id) {
        fournisseurService.delete(id);
        return ResponseEntity.noContent().build();
    }
}