package com.restapi.gestion_bons.service;

import org.springframework.stereotype.Service;

import com.restapi.gestion_bons.dao.ProductDAO;
import com.restapi.gestion_bons.entitie.Product;
import com.restapi.gestion_bons.dto.product.ProductCreateDTO;
import com.restapi.gestion_bons.dto.product.ProductResponseDTO;
import com.restapi.gestion_bons.dto.product.ProductUpdateDTO;
import com.restapi.gestion_bons.mapper.ProductMapper;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductDAO productDAO;
    private final ProductMapper productMapper;

    public List<ProductResponseDTO> findAll() {
        return productDAO.findAll().stream().map(productMapper::toResponseDto).toList();
    }

    public Optional<ProductResponseDTO> findById(Long id) {
        return productDAO.findById(id).map(productMapper::toResponseDto);
    }

    public ProductResponseDTO save(ProductCreateDTO dto) {
        Product p = productMapper.toEntity(dto);
        Product saved = productDAO.save(p);
        return productMapper.toResponseDto(saved);
    }

    public ProductResponseDTO update(Long id, ProductUpdateDTO dto) {
        return productDAO.findById(id).map(existing -> {
            Product updated = productMapper.toEntity(dto);
            // copy mutable fields from mapped updated to existing
            existing.setReference(updated.getReference());
            existing.setName(updated.getName());
            existing.setDescription(updated.getDescription());
            existing.setUnitPrice(updated.getUnitPrice());
            existing.setCategory(updated.getCategory());
            existing.setCurrentStock(updated.getCurrentStock());
            existing.setReorderPoint(updated.getReorderPoint());
            existing.setUnitOfMeasure(updated.getUnitOfMeasure());
            Product saved = productDAO.save(existing);
            return productMapper.toResponseDto(saved);
        }).orElseThrow(() -> new NoSuchElementException("Product not found with id " + id));
    }

    public void delete(Long id) {
        productDAO.deleteById(id);
    }
}
