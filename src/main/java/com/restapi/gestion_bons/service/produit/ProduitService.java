package com.restapi.gestion_bons.service.produit;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.restapi.gestion_bons.contracts.ProduitServiceContract;
import com.restapi.gestion_bons.dao.ProduitDAO;
import com.restapi.gestion_bons.entitie.Lot;
import com.restapi.gestion_bons.entitie.Produit;
import com.restapi.gestion_bons.dto.produit.ProduitResponseDTO;
import com.restapi.gestion_bons.dto.produit.ProduitRequestDTO;
import com.restapi.gestion_bons.exception.DuplicateResourceException;
import com.restapi.gestion_bons.mapper.ProduitMapper;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Primary
@RequiredArgsConstructor
public class ProduitService implements ProduitServiceContract {
    private final ProduitDAO produitDAO;
    private final ProduitMapper produitMapper;

    public List<ProduitResponseDTO> findAll() {
        return produitDAO.findAll().stream().map(produitMapper::toResponseDto).toList();
    }

    public Optional<ProduitResponseDTO> findById(Long id) {
        return produitDAO.findById(id).map(produitMapper::toResponseDto);
    }

    public ProduitResponseDTO save(ProduitRequestDTO dto) {
        if (dto.getReference() != null && produitDAO.findByReference(dto.getReference()) != null) {
            throw new DuplicateResourceException("reference", dto.getReference());
        }
        if (dto.getNom() != null && produitDAO.findByName(dto.getNom()) != null) {
            throw new DuplicateResourceException("name", dto.getNom());
        }
        Produit p = produitMapper.toEntity(dto);
        Produit saved = produitDAO.save(p);
        return produitMapper.toResponseDto(saved);
    }

    public ProduitResponseDTO update(Long id, ProduitRequestDTO dto) {
        return produitDAO.findById(id).map(existing -> {
            // if reference changed, ensure new reference is not taken
            if (dto.getReference() != null && !dto.getReference().equals(existing.getReference())) {
                Produit byRef = produitDAO.findByReference(dto.getReference());
                if (byRef != null && !byRef.getId().equals(id)) {
                    throw new DuplicateResourceException("reference", dto.getReference());
                }
            }
            // if name changed, ensure new name is not taken
            if (dto.getNom() != null && !dto.getNom().equals(existing.getNom())) {
                Produit byName = produitDAO.findByName(dto.getNom());
                if (byName != null && !byName.getId().equals(id)) {
                    throw new DuplicateResourceException("name", dto.getNom());
                }
            }

            Produit updated = produitMapper.toEntity(dto);
            existing.setReference(updated.getReference());
            existing.setNom(updated.getNom());
            existing.setDescription(updated.getDescription());
            existing.setCategorie(updated.getCategorie());
            existing.setUniteMesure(updated.getUniteMesure());
            Produit saved = produitDAO.save(existing);
            return produitMapper.toResponseDto(saved);
        }).orElseThrow(() -> new NoSuchElementException("Produit not found with id " + id));
    }

    public void delete(Long id) {
        produitDAO.deleteById(id);
    }

    public Optional<ProduitResponseDTO> findByName(String name) {
        return Optional.ofNullable(produitDAO.findByName(name)).map(produitMapper::toResponseDto);
    }

    public Optional<ProduitResponseDTO> findByReference(String reference) {
        return Optional.ofNullable(produitDAO.findByReference(reference)).map(produitMapper::toResponseDto);
    }

    public List<ProduitResponseDTO> findByCategory(String category) {
        return produitDAO.findByCategory(category).stream().map(produitMapper::toResponseDto).toList();
    }

    public List<Lot> findLotsByProduitId(Long id) {
        Optional<Produit> p = produitDAO.findById(id);
        if (p.isEmpty())
            return List.of();
        return p.get().getLots();
    }
}
