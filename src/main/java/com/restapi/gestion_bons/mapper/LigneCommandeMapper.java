package com.restapi.gestion_bons.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.restapi.gestion_bons.dto.lignecommande.LigneCommandeResponseDTO;
import com.restapi.gestion_bons.dto.commandefournisseur.CommandeFournisseurRequestDTO.LigneCommandeRequestDTO;
import com.restapi.gestion_bons.entitie.LigneCommande;

import java.util.List;

@Mapper(componentModel = "spring", uses = { ProduitMapper.class })
public interface LigneCommandeMapper {

    LigneCommandeResponseDTO toResponseDto(LigneCommande ligne);

    @Mapping(target = "produit.id", source = "produitId")
    @Mapping(target = "commande", ignore = true)
    @Mapping(target = "id", ignore = true)
    LigneCommande toEntity(LigneCommandeRequestDTO dto);

    List<LigneCommandeResponseDTO> toResponseDtoList(List<LigneCommande> lignes);

    List<LigneCommande> toEntityList(List<LigneCommandeRequestDTO> dtos);
}
