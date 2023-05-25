package com.example.pfecompagnemailling.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Modele implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String sujet;
    @Column(length = 750)
    private String contenu;
    private String signature;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modele")
    @JsonIgnore
    private Set<CampagneMailing> campagneMailing;
}
