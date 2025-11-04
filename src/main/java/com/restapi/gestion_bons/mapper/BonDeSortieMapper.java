package com.restapi.gestion_bons.mapper;

import com.restapi.gestion_bons.dto.bonDeSortie.BonDeSortieCreateDTO;
import com.restapi.gestion_bons.dto.bonDeSortie.BonDeSortieResponseDTO;
import com.restapi.gestion_bons.entitie.BonDeSortie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BonDeSortieMapper {

    // responnse
    @Mapping(target = "atelier_destinataire_id", source = "atelier.id")
    BonDeSortieResponseDTO toResponseDto(BonDeSortie bonDeSortie);

    // create
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "atelier.id", source = "atelier_destinataire_id")
    @Mapping(target = "statut", ignore = true)
    @Mapping(target = "bonDeSortieLignes", ignore = true)
    @Mapping(target = "mouvementsStocks", ignore = true)
    BonDeSortieCreateDTO toCreateDto(BonDeSortie bonDeSortie);

    // update
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "atelier.id", source = "atelier_destinataire_id")
    @Mapping(target = "statut", ignore = true)
    @Mapping(target = "bonDeSortieLignes", ignore = true)
    @Mapping(target = "mouvementsStocks", ignore = true)
    void updateEntityFromDto(BonDeSortieCreateDTO bonDeSortieCreateDTO, @MappingTarget BonDeSortie bonDeSortie);

    // list mapping
    List<BonDeSortieResponseDTO> toResponseDtoList(List<BonDeSortie> bonDeSorties);

}