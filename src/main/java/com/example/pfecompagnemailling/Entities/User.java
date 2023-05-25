package com.example.pfecompagnemailling.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable , UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(role.getLibelle()));

    }

    @Override
    public String getPassword() {
     return motdepasse ; 
    }

    @Override
    public String getUsername() {
      return login ;
    }

    @Override
    public boolean isAccountNonExpired() {
    return true ;
    }

    @Override
    public boolean isAccountNonLocked() {
        return active ; 
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true ;
    }

    @Override
    public boolean isEnabled() {
        return true ;
    }
}
