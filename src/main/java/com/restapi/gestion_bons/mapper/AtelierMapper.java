package com.restapi.gestion_bons.mapper;

import com.restapi.gestion_bons.dto.atelier.AtelierCreateDTO;
import com.restapi.gestion_bons.dto.atelier.AtelierResponseDTO;
import com.restapi.gestion_bons.dto.atelier.AtelierUpdateDTO;
import com.restapi.gestion_bons.entitie.Atelier;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AtelierMapper {

    // Entity response DTO
    AtelierResponseDTO toResponseDto(Atelier atelier);

    // Create dto to entity
    @Mapping(target = "id", ignore = true)
    Atelier toEntity(AtelierCreateDTO createDTO);

    // Update dto to entity
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(AtelierUpdateDTO updateDTO, @MappingTarget Atelier atelier);

    // List mapping
    List<AtelierResponseDTO> toResponseDtoList(List<Atelier> atelier);

}
