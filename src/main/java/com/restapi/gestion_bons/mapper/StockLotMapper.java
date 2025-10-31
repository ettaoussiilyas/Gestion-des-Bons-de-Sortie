package com.restapi.gestion_bons.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.restapi.gestion_bons.dto.stocklot.BaseStockLotDTO;
import com.restapi.gestion_bons.dto.stocklot.ResponseStockLotDTO;
import com.restapi.gestion_bons.entitie.StockLot;

@Mapper(componentModel = "spring", uses = { ProductMapper.class })
public interface StockLotMapper {

    @Mapping(target = "productId", source = "product.id")
    ResponseStockLotDTO toResponseDto(StockLot stockLot);

    @Mapping(target = "product.id", source = "productId")
    @Mapping(target = "commandeFournisseur.id", source = "commandeFournisseurId")
    StockLot toEntity(ResponseStockLotDTO dto);

    @Mapping(target = "product.id", source = "productId")
    StockLot toEntity(BaseStockLotDTO bsl);

    List<ResponseStockLotDTO> toResponseDtoList(List<StockLot> stockLots);

    List<StockLot> toEntityList(List<ResponseStockLotDTO> dtos);
}
