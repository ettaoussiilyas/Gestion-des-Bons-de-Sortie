package com.restapi.gestion_bons.contracts;

import com.restapi.gestion_bons.dto.lignecommande.LigneCommandeCreateDTO;
import com.restapi.gestion_bons.dto.lignecommande.LigneCommandeResponseDTO;
import com.restapi.gestion_bons.dto.lignecommande.LigneCommandeUpdateDTO;
import com.restapi.gestion_bons.entitie.LigneCommande;

import java.util.List;

public interface LigneCommandeContract {

    LigneCommandeResponseDTO save(LigneCommandeCreateDTO createDTO);

    LigneCommandeResponseDTO update(Long id, LigneCommandeUpdateDTO updateDTO);

    LigneCommandeResponseDTO findById(Long id);

    List<LigneCommandeResponseDTO> findAll();

    void delete(Long id);

}
