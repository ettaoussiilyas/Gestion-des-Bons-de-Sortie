package com.restapi.gestion_bons.mapper;

import com.restapi.gestion_bons.dto.commandefournisseur.CommandeFournisseurCreateDTO;
import com.restapi.gestion_bons.dto.commandefournisseur.CommandeFournisseurResponseDTO;
import com.restapi.gestion_bons.dto.commandefournisseur.CommandeFournisseurUpdateDTO;
import com.restapi.gestion_bons.entitie.CommandeFournisseur;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CommandeFournisseurMapper.class})
public interface CommandeFournisseurMapper {

    CommandeFournisseurResponseDTO toResponseDto(CommandeFournisseur commandeFournisseur);

    CommandeFournisseurResponseDTO toResponseDto(CommandeFournisseurCreateDTO fournisseurCreateDTO);

    CommandeFournisseurResponseDTO toResponseDto(CommandeFournisseurUpdateDTO fournisseurUpdateDTO);

    CommandeFournisseur toEntityCreate(CommandeFournisseurCreateDTO createDTO);

    CommandeFournisseur toEntityUpdate(CommandeFournisseurUpdateDTO updateDTO);

    CommandeFournisseur toEntityResponse(CommandeFournisseurResponseDTO responseDTO);
}
