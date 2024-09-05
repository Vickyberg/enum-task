package com.example.demo.services.verification;

import com.example.demo.data.models.entities.VerificationToken;
import com.example.demo.data.models.enums.TokenType;
import com.example.demo.data.repositories.VerificationTokenRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VerificationTokenServiceImpl implements VerificationTokenService {
    private final VerificationTokenRepo verificationTokenRepository;


    @Override
    public VerificationToken createInvitationToken(String email) {
        String rawToken = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken(
                rawToken,
                LocalDateTime.now().plusHours(24),
                email,
                TokenType.INVITATION_TOKEN

        );
        return verificationTokenRepository.save(verificationToken);
    }
}
