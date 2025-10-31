package com.restapi.gestion_bons.service;

import com.restapi.gestion_bons.dao.FournisseurDAO;
import com.restapi.gestion_bons.dto.FournisseurDTO;
import com.restapi.gestion_bons.entitie.Fournisseur;
import com.restapi.gestion_bons.mapper.FournisseurMapper;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FournisseurService {
    private final FournisseurDAO fournisseurDAO;
    private final FournisseurMapper fournisseurMapper;

    public FournisseurService(FournisseurDAO fournisseurDAO, FournisseurMapper fournisseurMapper) {
        this.fournisseurDAO = fournisseurDAO;
        this.fournisseurMapper = fournisseurMapper;
    }

    public List<FournisseurDTO> findAll() {
        return fournisseurDAO.findAll().stream()
                .map(fournisseurMapper::toDTO)
                .collect(Collectors.toList());
    }

    public FournisseurDTO findById(Long id) {
        return fournisseurDAO.findById(id)
                .map(fournisseurMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Fournisseur not found with id: " + id));
    }

    public FournisseurDTO save(FournisseurDTO fournisseurDTO) {
        Fournisseur fournisseur = fournisseurMapper.toEntity(fournisseurDTO);
        Fournisseur saved = fournisseurDAO.save(fournisseur);
        return fournisseurMapper.toDTO(saved);
    }

    public FournisseurDTO update(Long id, FournisseurDTO fournisseurDTO) {
        return fournisseurDAO.findById(id)
                .map(existing -> {
                    Fournisseur toUpdate = fournisseurMapper.toEntity(fournisseurDTO);
                    toUpdate.setId(id);
                    return fournisseurMapper.toDTO(fournisseurDAO.save(toUpdate));
                })
                .orElseThrow(() -> new EntityNotFoundException("Fournisseur not found with id: " + id));
    }

    public void delete(Long id) {
        if (!fournisseurDAO.existsById(id)) {
            throw new EntityNotFoundException("Fournisseur not found with id: " + id);
        }
        fournisseurDAO.deleteById(id);
    }
}