package com.example.pfecompagnemailling.Repository;

import com.example.pfecompagnemailling.Entities.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigurationRepository extends JpaRepository<Configuration, Integer> {
}