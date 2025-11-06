package com.restapi.gestion_bons.service.ligneCommande;

import com.restapi.gestion_bons.contracts.LigneCommandeContract;
import com.restapi.gestion_bons.dao.CommandeFournisseurDAO;
import com.restapi.gestion_bons.dao.LigneCommandeDAO;
import com.restapi.gestion_bons.dao.ProduitDAO;
import com.restapi.gestion_bons.dto.lignecommande.LigneCommandeCreateDTO;
import com.restapi.gestion_bons.dto.lignecommande.LigneCommandeResponseDTO;
import com.restapi.gestion_bons.dto.lignecommande.LigneCommandeUpdateDTO;
import com.restapi.gestion_bons.entitie.CommandeFournisseur;
import com.restapi.gestion_bons.entitie.LigneCommande;
import com.restapi.gestion_bons.entitie.Produit;
import com.restapi.gestion_bons.mapper.LigneCommandeMapper;
import jakarta.persistence.EntityNotFoundException;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LigneCommandeService implements LigneCommandeContract {

    private final LigneCommandeDAO ligneCommandeDAO;
    private final LigneCommandeMapper ligneCommandeMapper;
    private final CommandeFournisseurDAO commandeFournisseurDAO;
    private final ProduitDAO produitDAO;

    public LigneCommandeService(
            LigneCommandeMapper ligneCommandeMapper,
            LigneCommandeDAO ligneCommandeDAO,
            CommandeFournisseurDAO commandeFournisseurDAO, ProduitDAO produitDAO){
        this.ligneCommandeDAO = ligneCommandeDAO;
        this.ligneCommandeMapper = ligneCommandeMapper;
        this.commandeFournisseurDAO = commandeFournisseurDAO;
        this.produitDAO = produitDAO;
    }


    @Override
    public LigneCommandeResponseDTO save(LigneCommandeCreateDTO createDTO) {
        if(createDTO.getCommandeId() == null || createDTO.getProduitId() == null){
            throw new IllegalArgumentException("produit id ou commannde id vide!");
        }

        CommandeFournisseur commandeFournisseur = commandeFournisseurDAO.findById(createDTO.getCommandeId())
                .orElseThrow(() -> new EntityNotFoundException("No commande avec cette id !"));

        Produit produit = produitDAO.findById(createDTO.getProduitId())
                .orElseThrow(() -> new EntityNotFoundException("No commande avec cette id !"));

        LigneCommande ligneCommande = ligneCommandeMapper.toEntity(createDTO);
        ligneCommande.setCommande(commandeFournisseur);
        ligneCommande.setProduit(produit);

        LigneCommande saved = ligneCommandeDAO.save(ligneCommande);
        return ligneCommandeMapper.toResponseDto(saved);
    }

    @Override
    public LigneCommandeResponseDTO update(Long id, LigneCommandeUpdateDTO updateDTO) {

        if(updateDTO.getCommandeId() == null || updateDTO.getProduitId() == null){
            throw new IllegalArgumentException("produit id ou commannde id vide!");
        }
        LigneCommande ligneExist = ligneCommandeDAO.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pas de ligne de commande avec cette id !"));

        CommandeFournisseur commandeFournisseur = commandeFournisseurDAO.findById(updateDTO.getCommandeId())
                .orElseThrow(() -> new EntityNotFoundException("No commande avec cette id !"));

        Produit produit = produitDAO.findById(updateDTO.getProduitId())
                .orElseThrow(() -> new EntityNotFoundException("No commande avec cette id !"));

        ligneExist.setCommande(commandeFournisseur);
        ligneExist.setProduit(produit);
        ligneExist.setQuantiteCommandee(updateDTO.getQuantiteCommandee());
        ligneExist.setPrixAchatUnitaire(updateDTO.getPrixAchatUnitaire());
        return ligneCommandeMapper.toResponseDto(ligneCommandeDAO.save(ligneExist));
    }

    @Override
    public LigneCommandeResponseDTO findById(Long id) {
        if (id == null || id <= 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id not Valid");
        }
        return ligneCommandeDAO.findById(id)
                .map(ligneCommandeMapper::toResponseDto)
                .orElseThrow(() -> new EntityNotFoundException("Pas de ligne de commande avec cette id !"));

    }

    @Override
    public List<LigneCommandeResponseDTO> findAll() {
        return List.of();
    }

    @Override
    public void delete(Long id) {

    }
}
