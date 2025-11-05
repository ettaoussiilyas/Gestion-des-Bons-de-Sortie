package com.restapi.gestion_bons.dao;

import com.restapi.gestion_bons.entitie.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneCommandeDAO extends JpaRepository<LigneCommande, Long> {
}
