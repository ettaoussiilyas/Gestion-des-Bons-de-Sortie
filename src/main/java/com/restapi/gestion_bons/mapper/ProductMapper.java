package com.restapi.gestion_bons.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.restapi.gestion_bons.dto.product.ProductResponseDTO;
import com.restapi.gestion_bons.dto.product.ProductRequestDTO;
import com.restapi.gestion_bons.entitie.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductResponseDTO toResponseDto(Product product);

    ProductResponseDTO toResponseDto(ProductRequestDTO product);

    ProductRequestDTO toProductRequestDTO(Product product);

    ProductRequestDTO toProductRequestDTO(ProductResponseDTO product);

    Product toEntity(ProductRequestDTO dto);

    Product toEntity(ProductResponseDTO dto);

    List<ProductResponseDTO> toResponseDtoList(List<Product> products);

    List<ProductRequestDTO> toProductRequestDtoList(List<Product> products);

    List<Product> toEntityList(List<ProductResponseDTO> dtos);
}
