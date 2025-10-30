package com.restapi.gestion_bons.dao;

import com.restapi.gestion_bons.entitie.Lot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LotDAO extends JpaRepository<Lot, Long> {
}
