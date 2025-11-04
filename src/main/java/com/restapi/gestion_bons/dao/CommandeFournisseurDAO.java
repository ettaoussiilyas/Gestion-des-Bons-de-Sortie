package com.restapi.gestion_bons.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.gestion_bons.entitie.CommandeFournisseur;

public interface CommandeFournisseurDAO extends JpaRepository<CommandeFournisseur, Long> {
}
