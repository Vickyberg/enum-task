package com.example.demo.services.email;

import com.example.demo.data.models.entities.Learner;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@Profile("default")
public class DevEmailService implements EmailService {


    @Override
    public void invitationMail(Learner learner, String token) {
        log.info("invitation token  => {}", token);
    }
}
