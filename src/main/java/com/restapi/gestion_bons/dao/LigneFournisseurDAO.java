package com.restapi.gestion_bons.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneFournisseurDAO extends JpaRepository<LigneFournisseurDAO, Long> {
}
