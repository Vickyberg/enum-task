package com.example.demo.data.repositories;

import com.example.demo.data.models.entities.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VerificationTokenRepo extends JpaRepository<VerificationToken, UUID> {
}
