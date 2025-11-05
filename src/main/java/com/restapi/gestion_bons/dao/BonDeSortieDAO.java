package com.restapi.gestion_bons.dao;

import com.restapi.gestion_bons.entitie.BonDeSortie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonDeSortieDAO extends JpaRepository<BonDeSortie, Long> {
}
