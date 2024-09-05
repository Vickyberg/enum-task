package com.example.demo.data.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Cohort> cohorts = new ArrayList<>();
    @OneToOne
    private Course course;

}
