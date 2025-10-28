package com.restapi.gestion_bons.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.gestion_bons.dao.ProductDAO;
import com.restapi.gestion_bons.entities.Product;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductDAO productDAO;

    @Autowired
    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<Product> findAll() {
        return productDAO.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productDAO.findById(id);
    }

    public Product save(Product product) {
        return productDAO.save(product);
    }

    public Product update(Long id, Product update) {
        return productDAO.findById(id).map(existing -> {
            // copy mutable fields
            existing.setReference(update.getReference());
            existing.setName(update.getName());
            existing.setDescription(update.getDescription());
            existing.setUnitPrice(update.getUnitPrice());
            existing.setCategory(update.getCategory());
            existing.setCurrentStock(update.getCurrentStock());
            existing.setReorderPoint(update.getReorderPoint());
            existing.setUnitOfMeasure(update.getUnitOfMeasure());
            return productDAO.save(existing);
        }).orElseThrow(() -> new NoSuchElementException("Product not found with id " + id));
    }

    public void delete(Long id) {
        productDAO.deleteById(id);
    }
}
