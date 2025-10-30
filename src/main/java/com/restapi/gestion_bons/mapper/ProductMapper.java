package com.restapi.gestion_bons.mapper;

import org.mapstruct.Mapper;

import com.restapi.gestion_bons.dto.product.ProductCreateDTO;
import com.restapi.gestion_bons.dto.product.ProductResponseDTO;
import com.restapi.gestion_bons.dto.product.ProductUpdateDTO;
import com.restapi.gestion_bons.entitie.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductResponseDTO toResponseDto(Product product);

    ProductResponseDTO toResponseDto(ProductCreateDTO product);

    ProductResponseDTO toResponseDto(ProductUpdateDTO product);

    Product toEntity(ProductCreateDTO dto);

    Product toEntity(ProductUpdateDTO dto);

    Product toEntity(ProductResponseDTO dto);

}
