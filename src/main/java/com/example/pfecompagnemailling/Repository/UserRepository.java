package com.example.pfecompagnemailling.Repository;

import com.example.pfecompagnemailling.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {


}