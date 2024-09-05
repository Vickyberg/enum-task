package com.example.demo.services.email;

import com.example.demo.data.models.entities.Learner;

public interface EmailService {
    void invitationMail(Learner learner, String token);
}
