package com.example.demo.services.verification;

import com.example.demo.data.models.entities.VerificationToken;

public interface VerificationTokenService {

    VerificationToken createInvitationToken(String email);
}
