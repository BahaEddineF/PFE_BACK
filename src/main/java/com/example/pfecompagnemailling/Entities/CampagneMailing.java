package com.example.pfecompagnemailling.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.ObjectInputFilter;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CampagneMailing implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String email;
    private String destinataire;
    private String etat;

    @Enumerated(EnumType.STRING)
    private ModeEnvoie modeEnvoie;

    @ManyToOne
    private Planification planification;

    @ManyToOne
    private Modele modele;

    @ManyToOne
    private Configuration configuration;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "campagneMailing")
    @JsonIgnore
    private Set<User> users;

}
