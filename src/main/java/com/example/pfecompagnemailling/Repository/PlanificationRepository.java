package com.example.pfecompagnemailling.Repository;

import com.example.pfecompagnemailling.Entities.Planification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanificationRepository extends JpaRepository<Planification, Integer> {
}