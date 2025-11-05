package com.restapi.gestion_bons.mapper;

import com.restapi.gestion_bons.dto.bonDeSortie.BonDeSortieCreateDTO;
import com.restapi.gestion_bons.dto.bonDeSortie.BonDeSortieResponseDTO;
import com.restapi.gestion_bons.dto.bonDeSortie.BonDeSortieUpdateDTO;
import com.restapi.gestion_bons.entitie.BonDeSortie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BonDeSortieMapper {

    // Entity to Response DTO
    @Mapping(target = "atelier_destinataire_id", source = "atelier.id")
    BonDeSortieResponseDTO toResponseDto(BonDeSortie bonDeSortie);

    // Create DTO to Entity (CORRECT DIRECTION)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "atelier.id", source = "atelier_destinataire_id")
    @Mapping(target = "statut", ignore = true)
    @Mapping(target = "bonDeSortieLignes", ignore = true)
    @Mapping(target = "mouvementsStocks", ignore = true)
    BonDeSortie toEntity(BonDeSortieCreateDTO createDTO);

    // Update DTO to Entity
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "atelier.id", source = "atelier_destinataire_id")
    @Mapping(target = "bonDeSortieLignes", ignore = true)
    @Mapping(target = "mouvementsStocks", ignore = true)
    void updateEntityFromDto(BonDeSortieUpdateDTO updateDTO, @MappingTarget BonDeSortie bonDeSortie);

    // List mappings
    List<BonDeSortieResponseDTO> toResponseDtoList(List<BonDeSortie> bonDeSorties);
}
