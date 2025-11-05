package com.restapi.gestion_bons.service.commandeFournisseur;

import com.restapi.gestion_bons.contracts.CommandeFournisseurContract;
import com.restapi.gestion_bons.dao.CommandeFournisseurDAO;
import com.restapi.gestion_bons.dto.commandefournisseur.CommandeFournisseurCreateDTO;
import com.restapi.gestion_bons.dto.commandefournisseur.CommandeFournisseurRequestDTO;
import com.restapi.gestion_bons.dto.commandefournisseur.CommandeFournisseurResponseDTO;
import com.restapi.gestion_bons.dto.commandefournisseur.CommandeFournisseurUpdateDTO;
import com.restapi.gestion_bons.entitie.CommandeFournisseur;
import com.restapi.gestion_bons.mapper.CommandeFournisseurMapper;
import com.restapi.gestion_bons.mapper.FournisseurMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommandeFournisseurService  implements CommandeFournisseurContract{

    private final CommandeFournisseurDAO commandeFournisseurDAO;
    private final CommandeFournisseurMapper commandeFournisseurMapper;

    public CommandeFournisseurService(CommandeFournisseurDAO commandeFournisseurDAO, CommandeFournisseurMapper commandeFournisseurMapper){
        this.commandeFournisseurDAO = commandeFournisseurDAO;
        this.commandeFournisseurMapper = commandeFournisseurMapper;
    }

    @Override
    public CommandeFournisseurResponseDTO save(CommandeFournisseurCreateDTO CreateDto) {
        CommandeFournisseur commandeFournisseur = commandeFournisseurMapper.toEntityCreate(CreateDto);
        CommandeFournisseur saved = commandeFournisseurDAO.save(commandeFournisseur);
        return commandeFournisseurMapper.toResponseDto(saved);
    }

    @Override
    public CommandeFournisseurResponseDTO update(Long id, CommandeFournisseurUpdateDTO updateDto) {
        if(!commandeFournisseurDAO.existsById(id)){
            throw new EntityNotFoundException("Commande Fournisseur Not Foun With This Id");
        }

        CommandeFournisseur toUpdate = commandeFournisseurMapper.toEntityUpdate(updateDto);
        toUpdate.setId(id);
        CommandeFournisseur update = commandeFournisseurDAO.save(toUpdate);
        return commandeFournisseurMapper.toResponseDto(update);
    }

    @Override
    public CommandeFournisseurResponseDTO findById(Long id) {

        return commandeFournisseurDAO.findById(id)
                .map(commandeFournisseurMapper::toResponseDto)
                .orElseThrow(() -> new EntityNotFoundException("Commande Fournisseur not found whit this Id !"));
    }

    @Override
    public List<CommandeFournisseurResponseDTO> findAll() {
        return commandeFournisseurDAO.findAll().stream()
                .map(commandeFournisseurMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
//        Optional<CommandeFournisseur> commandeFournisseur = commandeFournisseurDAO.findById(id);
//        commandeFournisseurDAO.delete(commandeFournisseur.get());

        if(!commandeFournisseurDAO.existsById(id)){
            throw new EntityNotFoundException("Not Fount with this id");
        }
        commandeFournisseurDAO.deleteById(id);
    }

    @Override
    public List<CommandeFournisseurResponseDTO> findByFournisseurId(Long fournisseurId) {
        return List.of();
    }
}
