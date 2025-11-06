package com.restapi.gestion_bons.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.restapi.gestion_bons.dto.commandefournisseur.CommandeFournisseurRequestDTO;
import com.restapi.gestion_bons.dto.commandefournisseur.CommandeFournisseurResponseDTO;
import com.restapi.gestion_bons.entitie.CommandeFournisseur;

import java.util.List;

@Mapper(componentModel = "spring", uses = { FournisseurMapper.class, LigneCommandeMapper.class })
public interface CommandeFournisseurMapper {

    CommandeFournisseurResponseDTO toResponseDto(CommandeFournisseur commande);

    @Mapping(target = "fournisseur.id", source = "fournisseurId")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "lots", ignore = true)
    CommandeFournisseur toEntity(CommandeFournisseurRequestDTO dto);

    List<CommandeFournisseurResponseDTO> toResponseDtoList(List<CommandeFournisseur> commandes);
}
