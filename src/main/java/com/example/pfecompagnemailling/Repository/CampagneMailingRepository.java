package com.example.pfecompagnemailling.Repository;

import com.example.pfecompagnemailling.Entities.CampagneMailing;
import com.example.pfecompagnemailling.Entities.ModeEnvoie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CampagneMailingRepository extends JpaRepository<CampagneMailing, Integer> {
    List<CampagneMailing> findAllByModeEnvoieAndEtat(ModeEnvoie mode,String etat);
}