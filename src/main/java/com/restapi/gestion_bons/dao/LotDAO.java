package com.restapi.gestion_bons.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.gestion_bons.entitie.Lot;

public interface LotDAO extends JpaRepository<Lot, Long> {

}
