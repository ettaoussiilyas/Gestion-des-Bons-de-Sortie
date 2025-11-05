package com.restapi.gestion_bons.contracts;

import java.util.List;

import com.restapi.gestion_bons.dto.bonDeSortie.BonDeSortieCreateDTO;
import com.restapi.gestion_bons.dto.bonDeSortie.BonDeSortieResponseDTO;
import com.restapi.gestion_bons.dto.bonDeSortie.BonDeSortieUpdateDTO;

public interface BonDeSortieContract {
    BonDeSortieResponseDTO save(BonDeSortieCreateDTO dto);

    BonDeSortieResponseDTO update(Long id, BonDeSortieUpdateDTO dto);

    BonDeSortieResponseDTO findById(Long id);

    List<BonDeSortieResponseDTO> findAll();

    void delete(Long id);

    BonDeSortieResponseDTO findByNumeroBon(String numeroBon);

    List<BonDeSortieResponseDTO> findByAtelierId(Long atelierId);
}
