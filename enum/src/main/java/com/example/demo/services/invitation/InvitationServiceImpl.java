package com.example.demo.services.invitation;

import com.example.demo.data.models.dtos.responses.InvitationResponse;
import com.example.demo.data.models.entities.Invitation;
import com.example.demo.data.models.entities.Learner;
import com.example.demo.data.models.entities.VerificationToken;
import com.example.demo.data.models.enums.InvitationStatus;
import com.example.demo.data.repositories.InvitationRepository;
import com.example.demo.data.repositories.LearnerRepository;
import com.example.demo.services.email.EmailService;
import com.example.demo.services.verification.VerificationTokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class InvitationServiceImpl  implements  InvitationService{
    public final VerificationTokenService verificationTokenService;
    private final LearnerRepository learnerRepository;
    private final EmailService emailService;
    private final InvitationRepository invitationRepository;
    @Override
    public InvitationResponse inviteLearner(String email) {
        Learner foundLearner = learnerRepository.findByEmail(email);

        if (foundLearner == null) {
            System.out.println("Learner not found for email: " + email);
            return InvitationResponse.builder()
                    .success(false)
                    .message("Learner not found for email: " + email)
                    .build();
        }

        try {
            VerificationToken verificationToken = verificationTokenService.createInvitationToken(email);
            emailService.invitationMail(foundLearner, verificationToken.getToken());
            Invitation invitation = Invitation.builder()
                    .learner(foundLearner)
                    .status(InvitationStatus.PENDING)
                    .build();
            invitationRepository.save(invitation);
            return InvitationResponse.builder()
                    .success(true)
                    .message("Invitation sent successfully to " + email)
                    .data(invitation)
                    .build();
        } catch (Exception e) {
            System.err.println("Error while sending invitation to " + email + ": " + e.getMessage());
            return InvitationResponse.builder()
                    .success(false)
                    .message("Error while sending invitation to " + email)
                    .build();
        }
    }

}
