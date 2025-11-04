package com.restapi.gestion_bons.dao;

import com.restapi.gestion_bons.entitie.MouvementStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MouvementStockDAO extends JpaRepository<MouvementStock, Long> {
}
