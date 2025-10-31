package com.restapi.gestion_bons.service.product;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.restapi.gestion_bons.contracts.ProductServiceContract;
import com.restapi.gestion_bons.dao.ProductDAO;
import com.restapi.gestion_bons.entitie.Product;
import com.restapi.gestion_bons.dto.product.ProductResponseDTO;
import com.restapi.gestion_bons.dto.product.ProductRequestDTO;
import com.restapi.gestion_bons.exception.DuplicateResourceException;
import com.restapi.gestion_bons.mapper.ProductMapper;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Primary
@RequiredArgsConstructor
public class ProductService implements ProductServiceContract {
    private final ProductDAO productDAO;
    private final ProductMapper productMapper;

    public List<ProductResponseDTO> findAll() {
        return productDAO.findAll().stream().map(productMapper::toResponseDto).toList();
    }

    public Optional<ProductResponseDTO> findById(Long id) {
        return productDAO.findById(id).map(productMapper::toResponseDto);
    }

    public ProductResponseDTO save(ProductRequestDTO dto) {
        if (dto.getReference() != null && productDAO.findByReference(dto.getReference()) != null) {
            throw new DuplicateResourceException("reference", dto.getReference());
        }
        if (dto.getName() != null && productDAO.findByName(dto.getName()) != null) {
            throw new DuplicateResourceException("name", dto.getName());
        }
        Product p = productMapper.toEntity(dto);
        Product saved = productDAO.save(p);
        return productMapper.toResponseDto(saved);
    }

    public ProductResponseDTO update(Long id, ProductRequestDTO dto) {
        return productDAO.findById(id).map(existing -> {
            // if reference changed, ensure new reference is not taken
            if (dto.getReference() != null && !dto.getReference().equals(existing.getReference())) {
                Product byRef = productDAO.findByReference(dto.getReference());
                if (byRef != null && !byRef.getId().equals(id)) {
                    throw new DuplicateResourceException("reference", dto.getReference());
                }
            }
            // if name changed, ensure new name is not taken
            if (dto.getName() != null && !dto.getName().equals(existing.getName())) {
                Product byName = productDAO.findByName(dto.getName());
                if (byName != null && !byName.getId().equals(id)) {
                    throw new DuplicateResourceException("name", dto.getName());
                }
            }

            Product updated = productMapper.toEntity(dto);
            existing.setReference(updated.getReference());
            existing.setName(updated.getName());
            existing.setDescription(updated.getDescription());
            existing.setCategory(updated.getCategory());
            existing.setUnitOfMeasure(updated.getUnitOfMeasure());
            Product saved = productDAO.save(existing);
            return productMapper.toResponseDto(saved);
        }).orElseThrow(() -> new NoSuchElementException("Product not found with id " + id));
    }

    public void delete(Long id) {
        productDAO.deleteById(id);
    }

    public Optional<ProductResponseDTO> findByName(String name) {
        return Optional.ofNullable(productDAO.findByName(name)).map(productMapper::toResponseDto);
    }

    public Optional<ProductResponseDTO> findByReference(String reference) {
        return Optional.ofNullable(productDAO.findByReference(reference)).map(productMapper::toResponseDto);
    }

    public List<ProductResponseDTO> findByCategory(String category) {
        return productDAO.findByCategory(category).stream().map(productMapper::toResponseDto).toList();
    }
}
