package com.example.demo.data.repositories;

import com.example.demo.data.models.entities.Learner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LearnerRepository extends JpaRepository<Learner, UUID> {
    Learner findByEmail(String email);
}
