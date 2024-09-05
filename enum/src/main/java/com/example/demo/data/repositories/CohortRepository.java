package com.example.demo.data.repositories;

import com.example.demo.data.models.entities.Cohort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CohortRepository extends JpaRepository<Cohort, UUID> {
}
