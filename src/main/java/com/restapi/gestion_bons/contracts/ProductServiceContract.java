package com.restapi.gestion_bons.contracts;

import java.util.List;
import java.util.Optional;

import com.restapi.gestion_bons.dto.product.ProductResponseDTO;
import com.restapi.gestion_bons.dto.product.ProductRequestDTO;

public interface ProductServiceContract {
    List<ProductResponseDTO> findAll();

    Optional<ProductResponseDTO> findById(Long id);

    ProductResponseDTO save(ProductRequestDTO dto);

    ProductResponseDTO update(Long id, ProductRequestDTO dto);

    void delete(Long id);

    Optional<ProductResponseDTO> findByName(String name);

    Optional<ProductResponseDTO> findByReference(String reference);

    List<ProductResponseDTO> findByCategory(String category);
}
