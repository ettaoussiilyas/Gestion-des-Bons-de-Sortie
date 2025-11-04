package com.restapi.gestion_bons.mapper;

import com.restapi.gestion_bons.dto.fournisseur.FournisseurCreateDTO;
import com.restapi.gestion_bons.dto.fournisseur.FournisseurResponseDTO;
import com.restapi.gestion_bons.dto.fournisseur.FournisseurUpdateDTO;
import com.restapi.gestion_bons.entitie.Fournisseur;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", uses = { FournisseurMapper.class })
public interface FournisseurMapper {


    FournisseurResponseDTO toResponseDto(Fournisseur fournisseur);

    FournisseurResponseDTO toResponseDto(FournisseurCreateDTO fournisseur);

    FournisseurResponseDTO toResponseDto(FournisseurUpdateDTO fournisseur);

    Fournisseur toEntity(FournisseurCreateDTO dto);

    Fournisseur toEntity(FournisseurUpdateDTO dto);

    Fournisseur toEntity(FournisseurResponseDTO dto);

}
