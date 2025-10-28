package com.restapi.gestion_bons.mapper;

import com.restapi.gestion_bons.dto.FournisseurDTO;
import com.restapi.gestion_bons.entitie.Fournisseur;
import org.springframework.stereotype.Component;

@Component
public class FournisseurMapper {

    public FournisseurDTO toDTO(Fournisseur fournisseur){
        return FournisseurDTO.builder()
                .id(fournisseur.getId())
                .raisonSociale(fournisseur.getRaisonSociale())
                .addressComplete(fournisseur.getAddressComplete())
                .personneContact(fournisseur.getPersonneContact())
                .email(fournisseur.getEmail())
                .telephone(fournisseur.getTelephone())
                .ville(fournisseur.getVille())
                .ice(fournisseur.getIce())
                .build();
    }

    public Fournisseur toEntity(FournisseurDTO dto){
        return Fournisseur.builder()
                .id(dto.getId())
                .raisonSociale(dto.getRaisonSociale())
                .addressComplete(dto.getAddressComplete())
                .personneContact(dto.getPersonneContact())
                .email(dto.getEmail())
                .telephone(dto.getTelephone())
                .ville(dto.getVille())
                .ice(dto.getIce())
                .build();
    }
}
