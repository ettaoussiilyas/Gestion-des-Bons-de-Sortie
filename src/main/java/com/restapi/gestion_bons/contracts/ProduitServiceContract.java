package com.restapi.gestion_bons.contracts;

import java.util.List;
import java.util.Optional;

import com.restapi.gestion_bons.dto.produit.ProduitResponseDTO;
import com.restapi.gestion_bons.entitie.Lot;
import com.restapi.gestion_bons.dto.produit.ProduitRequestDTO;

public interface ProduitServiceContract {
    List<ProduitResponseDTO> findAll();

    Optional<ProduitResponseDTO> findById(Long id);

    ProduitResponseDTO save(ProduitRequestDTO dto);

    ProduitResponseDTO update(Long id, ProduitRequestDTO dto);

    void delete(Long id);

    Optional<ProduitResponseDTO> findByNom(String name);

    Optional<ProduitResponseDTO> findByReference(String reference);

    List<ProduitResponseDTO> findByCategorie(String category);
}
