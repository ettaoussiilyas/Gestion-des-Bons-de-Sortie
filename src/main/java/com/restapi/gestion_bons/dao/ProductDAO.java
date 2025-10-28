package com.restapi.gestion_bons.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.gestion_bons.entitie.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long> {

}
