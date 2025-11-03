package com.restapi.gestion_bons.dao;

import java.util.List;

import com.restapi.gestion_bons.entitie.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDAO extends JpaRepository<Produit, Long> {
    Produit findByReference(String reference);

    Produit findByName(String name);

    List<Produit> findByCategory(String category);
}
