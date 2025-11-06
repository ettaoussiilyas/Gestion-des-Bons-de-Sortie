package com.restapi.gestion_bons.service.commandeFournisseur;

import com.restapi.gestion_bons.contracts.CommandeFournisseurContract;
import com.restapi.gestion_bons.dao.CommandeFournisseurDAO;
import com.restapi.gestion_bons.dto.commandefournisseur.CommandeFournisseurCreateDTO;
import com.restapi.gestion_bons.dto.commandefournisseur.CommandeFournisseurResponseDTO;
import com.restapi.gestion_bons.dto.commandefournisseur.CommandeFournisseurUpdateDTO;
import com.restapi.gestion_bons.entitie.CommandeFournisseur;
import com.restapi.gestion_bons.entitie.Fournisseur;
import com.restapi.gestion_bons.entitie.enums.CommandeStatus;
import com.restapi.gestion_bons.mapper.CommandeFournisseurMapper;
import com.restapi.gestion_bons.service.fournisseur.FournisseurService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommandeFournisseurService  implements CommandeFournisseurContract{

    private final CommandeFournisseurDAO commandeFournisseurDAO;
    private final CommandeFournisseurMapper commandeFournisseurMapper;
    private final FournisseurService fournisseurService;

    public CommandeFournisseurService(CommandeFournisseurDAO commandeFournisseurDAO,
                                      CommandeFournisseurMapper commandeFournisseurMapper,
                                      FournisseurService fournisseurService){
        this.commandeFournisseurDAO = commandeFournisseurDAO;
        this.commandeFournisseurMapper = commandeFournisseurMapper;
        this.fournisseurService = fournisseurService;
    }

    @Override
    public CommandeFournisseurResponseDTO save(CommandeFournisseurCreateDTO CreateDto) {
        CommandeFournisseur commandeFournisseur = commandeFournisseurMapper.toEntityCreate(CreateDto);
        CommandeFournisseur saved = commandeFournisseurDAO.save(commandeFournisseur);
        return commandeFournisseurMapper.toResponseDto(saved);
    }

    @Override
    public CommandeFournisseurResponseDTO update(Long id, CommandeFournisseurUpdateDTO updateDto) {

        CommandeFournisseur existing = commandeFournisseurDAO.findById(id).orElseThrow(() -> new EntityNotFoundException("not found"));
        existing.setDateCommande(updateDto.getDateCommande());
        existing.setMontantTotal(updateDto.getMontantTotal());
        existing.setStatut(updateDto.getStatut());
        if(updateDto.getFournisseurId() != null){
            Fournisseur fournisseur = new Fournisseur();
            fournisseur.setId(updateDto.getFournisseurId());
            existing.setFournisseur(fournisseur);
        }
        CommandeFournisseur update = commandeFournisseurDAO.save(existing);
        return commandeFournisseurMapper.toResponseDto(update);
    }

    @Override
    public CommandeFournisseurResponseDTO findById(Long id) {

//        if(!commandeFournisseurDAO.existsById(id))
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
        if (!fournisseurService.existes(fournisseurId)){
            throw new EntityNotFoundException("There is no Fournisseur with this id");
        }
        return commandeFournisseurDAO.findByFournisseurId(fournisseurId).stream()
                .map(commandeFournisseurMapper::toResponseDto).collect(Collectors.toList());
    }

    public CommandeFournisseurResponseDTO receptionnerCommande(Long id){
        CommandeFournisseur commande = commandeFournisseurDAO.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Commande Not Found With This Id : " + id));
        commande.setStatut(CommandeStatus.LIVREE);
        CommandeFournisseur saved = commandeFournisseurDAO.save(commande);
        return commandeFournisseurMapper.toResponseDto(saved);

    }

}
