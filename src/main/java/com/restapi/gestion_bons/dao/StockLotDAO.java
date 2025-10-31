package com.restapi.gestion_bons.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.gestion_bons.entitie.StockLot;

public interface StockLotDAO extends JpaRepository<StockLot, Long> {

}
