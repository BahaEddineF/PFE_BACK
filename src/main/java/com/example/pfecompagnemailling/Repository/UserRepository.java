package com.example.pfecompagnemailling.Repository;

import com.example.pfecompagnemailling.Entities.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAllByRoleLibelle(String libelle);

    Optional<User> findByLogin(String login);
}