package com.example.demo.data.repositories;

import com.example.demo.data.models.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InstructorRepository extends JpaRepository<Instructor, UUID> {

    Instructor findByEmail(String email);

}
