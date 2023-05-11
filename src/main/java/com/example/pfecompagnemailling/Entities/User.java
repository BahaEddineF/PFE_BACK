package com.example.pfecompagnemailling.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.io.Serializable;
import java.util.Date;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private String nom;
    private String prenom;
    private String login;
    private String email;
    private String motdepasse;
   
    private Date datenaissance;

    @ManyToMany
    private List<CampagneMailing> campagneMailing;

    @ManyToOne
    private Role role;

    private boolean active;
}
