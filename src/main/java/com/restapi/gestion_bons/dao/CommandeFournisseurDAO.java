package com.restapi.gestion_bons.dao;

import com.restapi.gestion_bons.entitie.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeFournisseurDAO extends JpaRepository<CommandeFournisseur, Long> {

    CommandeFournisseur findByStatut(String statut);
}
