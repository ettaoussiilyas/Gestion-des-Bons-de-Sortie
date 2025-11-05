package com.restapi.gestion_bons.contracts;

import java.util.List;

import com.restapi.gestion_bons.dto.commandefournisseur.CommandeFournisseurRequestDTO;
import com.restapi.gestion_bons.dto.commandefournisseur.CommandeFournisseurResponseDTO;

public interface CommandeFournisseurContract {
    CommandeFournisseurResponseDTO save(CommandeFournisseurRequestDTO dto);

    CommandeFournisseurResponseDTO update(Long id, CommandeFournisseurRequestDTO dto);

    CommandeFournisseurResponseDTO findById(Long id);

    List<CommandeFournisseurResponseDTO> findAll();

    void delete(Long id);

    List<CommandeFournisseurResponseDTO> findByFournisseurId(Long fournisseurId);
}
