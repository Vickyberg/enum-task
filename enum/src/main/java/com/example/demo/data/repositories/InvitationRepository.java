package com.example.demo.data.repositories;

import com.example.demo.data.models.entities.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InvitationRepository extends JpaRepository<Invitation, UUID> {
}
