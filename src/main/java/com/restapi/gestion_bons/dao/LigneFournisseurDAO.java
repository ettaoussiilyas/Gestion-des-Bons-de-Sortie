package com.restapi.gestion_bons.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.gestion_bons.entitie.LigneCommande;

public interface LigneFournisseurDAO extends JpaRepository<LigneCommande, Long> {
}
