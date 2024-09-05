package com.example.demo.data.models.entities;

import com.example.demo.data.models.enums.Program;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
public class Cohort {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private  String cohortName;
    private String description;
    private Program program;
    private LocalDate startDate;
    private LocalDate endDate;
    private String cohortAvatarUrl;
    @OneToMany
    private Set<Instructor> instructor = new HashSet<>();
}
