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
public class Configuration implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String smtpserver;
    private int port;
    private String url;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "configuration")
    @JsonIgnore
    private Set<CampagneMailing> campagneMailings;

}
