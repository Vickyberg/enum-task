package com.example.demo.data.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String courseTitle;
    private String description;
    @ManyToOne
    private Instructor instructor;
}
