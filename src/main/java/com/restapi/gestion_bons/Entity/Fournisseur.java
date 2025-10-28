package com.restapi.gestion_bons.Entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@Table(name = "fournisseur")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Fournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(name = "raison_social", nullable = false)
    private String raisonSociale;

    @Column(name = "addresse_complet", nullable = false)
    private String addresseComplet;

    @Column(name = "personne_contact")
    @Nullable
    private String personneContact;

    @Email
    @NotBlank
    @Column(unique = true, nullable = false)
    private String email;

    @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$")
    private String telephone;

    private String ville;

    @Column(unique = true)
    private String ice;

}
