package com.example.demo.data.models.entities;

import com.example.demo.data.models.enums.TokenType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class VerificationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NonNull
    private String token;
    @NonNull
    private LocalDateTime expiredAt;
    private LocalDateTime confirmedAt;
    private LocalDateTime createdAt = LocalDateTime.now();
    @NonNull
    private String email;
    @NonNull
    private TokenType tokenType;
}
