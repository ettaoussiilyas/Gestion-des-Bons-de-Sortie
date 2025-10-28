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
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(name = "raison_social", nullable = false)
    private String raisonSociale;

    @Column(name = "address_complete", nullable = false)
    private String addressComplete;

    @Column(name = "personne_contact")
    private String personneContact;

    @Column(unique = true, nullable = false)
    private String email;

    @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$")
    private String telephone;

    private String ville;

    private String ice;

}
