package com.restapi.gestion_bons.dao;

import com.restapi.gestion_bons.entitie.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FournisseurDAO extends JpaRepository<Fournisseur, Long> {

    Fournisseur findByEmail(String email);

    List<Fournisseur> findFournisseurByEmailEndsWith(String extention);

    @Query("SELECT f from Fournisseur f where f.email like concat('%', :extention)")
    List<Fournisseur> findFournisseurByExtentionEmail(@Param("extention") String extention);
}
