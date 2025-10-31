package com.restapi.gestion_bons.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.gestion_bons.entitie.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long> {
    Product findByReference(String reference);

    Product findByName(String name);

    List<Product> findByCategory(String category);
}
