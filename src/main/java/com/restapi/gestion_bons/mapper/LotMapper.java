package com.restapi.gestion_bons.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.restapi.gestion_bons.dto.Lot.BaseLotDTO;
import com.restapi.gestion_bons.dto.Lot.ResponseLotDTO;
import com.restapi.gestion_bons.entitie.Lot;

@Mapper(componentModel = "spring", uses = { ProductMapper.class })
public interface LotMapper {

    @Mapping(target = "productId", source = "product.id")
    ResponseLotDTO toResponseDto(Lot lot);

    @Mapping(target = "product.id", source = "productId")
    @Mapping(target = "commandeFournisseur.id", source = "commandeFournisseurId")
    Lot toEntity(ResponseLotDTO dto);

    @Mapping(target = "product.id", source = "productId")
    Lot toEntity(BaseLotDTO bsl);

    List<ResponseLotDTO> toResponseDtoList(List<Lot> lots);

    List<Lot> toEntityList(List<ResponseLotDTO> dtos);
}
