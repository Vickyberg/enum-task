package com.example.demo.data.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
public class Learner {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    @ManyToOne
    @JoinColumn(name = "cohort_id")
    private Cohort cohort;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Course> courses = new ArrayList<>();

}
