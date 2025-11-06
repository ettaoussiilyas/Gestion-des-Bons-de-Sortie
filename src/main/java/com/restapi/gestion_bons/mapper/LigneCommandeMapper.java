package com.restapi.gestion_bons.mapper;

import com.restapi.gestion_bons.dto.lignecommande.LigneCommandeCreateDTO;
import com.restapi.gestion_bons.dto.lignecommande.LigneCommandeResponseDTO;
import com.restapi.gestion_bons.dto.lignecommande.LigneCommandeUpdateDTO;
import com.restapi.gestion_bons.entitie.LigneCommande;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LigneCommandeMapper {

    @Mapping(target = "commandeId", source = "commande.id")
    @Mapping(target = "produitId", source = "produit.id")
    LigneCommandeResponseDTO toResponseDto(LigneCommande ligneCommande);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "commandeId", source = "commande.id")
    @Mapping(target = "produit.id", source = "produitId")
    LigneCommandeResponseDTO toEntity(LigneCommandeCreateDTO createDTO);


    @Mapping(target = "commandeId", source = "commande.id")
    @Mapping(target = "produitId", source = "produit.id")
    void updateEntityFromDto (LigneCommandeUpdateDTO updateDTO, @MappingTarget LigneCommande ligneCommande);

    //List Mapping
    List<LigneCommandeResponseDTO> toResponseDtoList(List<LigneCommande> ligneCommandes);


}
