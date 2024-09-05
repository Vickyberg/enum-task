package com.example.demo.data.models.entities;

import com.example.demo.data.models.enums.InvitationStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Builder
public class Invitation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Cohort cohort;

    @ManyToOne
    private Learner learner;

    @Enumerated(EnumType.STRING)
    private InvitationStatus status;
}
