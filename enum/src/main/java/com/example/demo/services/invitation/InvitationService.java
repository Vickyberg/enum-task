package com.example.demo.services.invitation;

import com.example.demo.data.models.dtos.responses.InvitationResponse;

public interface InvitationService {
    InvitationResponse inviteLearner(String email);
}
