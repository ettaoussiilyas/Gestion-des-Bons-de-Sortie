package com.restapi.gestion_bons.mapper;

import java.util.List;

import com.restapi.gestion_bons.entitie.Produit;
import org.mapstruct.Mapper;

import com.restapi.gestion_bons.dto.product.ProductResponseDTO;
import com.restapi.gestion_bons.dto.product.ProductRequestDTO;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductResponseDTO toResponseDto(Produit produit);

    ProductResponseDTO toResponseDto(ProductRequestDTO product);

    ProductRequestDTO toProductRequestDTO(Produit produit);

    ProductRequestDTO toProductRequestDTO(ProductResponseDTO product);

    Produit toEntity(ProductRequestDTO dto);

    Produit toEntity(ProductResponseDTO dto);

    List<ProductResponseDTO> toResponseDtoList(List<Produit> produits);

    List<ProductRequestDTO> toProductRequestDtoList(List<Produit> produits);

    List<Produit> toEntityList(List<ProductResponseDTO> dtos);
}
