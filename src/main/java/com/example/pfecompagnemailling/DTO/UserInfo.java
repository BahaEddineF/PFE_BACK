package com.example.pfecompagnemailling.DTO;

import java.util.Date;

import com.example.pfecompagnemailling.Entities.User;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Builder
@Getter
@Setter
public class UserInfo {
    private int id ;
    private String nom;
    private String prenom;
    private String email;
    private String login ;
    private Date dateDeNaissance;
    private boolean active;

    public static UserInfo fromEntity(User user)
    {
        return UserInfo.builder()
        .id(user.getId())
        .nom(user.getNom())
        .prenom(user.getPrenom())
        .email(user.getEmail())
        .login(user.getLogin())
        .dateDeNaissance(user.getDatenaissance())
        .active(user.isActive())
        .build();
        
    }

   

  
}
