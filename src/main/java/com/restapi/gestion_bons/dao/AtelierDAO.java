package com.restapi.gestion_bons.dao;

import com.restapi.gestion_bons.entitie.Atelier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtelierDAO extends JpaRepository<Atelier, Long> {
}
