package com.example.demo.services.email;

import com.example.demo.data.models.dtos.requests.SendEmailRequest;
import com.example.demo.data.models.entities.Learner;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.springframework.util.StringUtils.capitalize;

@Service
@RequiredArgsConstructor
@Slf4j
@Profile("!default")
public class ProdEmailService implements EmailService{

    @Value("${spring.mail.username}")
    private String sender;
    @Value("${enum.app.frontend-host}")
    private String frontEndHost;
    private final ResourceLoader resourceLoader;
    private final JavaMailSender javaMailSender;

    @Override
    public void invitationMail(Learner learner, String token) {

        sendEmail(SendEmailRequest.builder()
                .emailAddress(learner.getEmail())
                .subject("Invitation to join a cohort at Enum")
                .message(String.format(readHtmlFile("static/invitation.html"),
                        capitalize(learner.getFirstName().toLowerCase()), frontEndHost + "/accept-invite/"+ token))
                .build());
        log.info("email verification token => {}", token);

    }


    @Async
    public void sendEmail(SendEmailRequest emailRequest) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");
            helper.setText(emailRequest.getMessage(), true);
            helper.setTo(emailRequest.getEmailAddress());
            helper.setFrom(sender);
            helper.setSubject(emailRequest.getSubject());

            javaMailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException("Error while Sending Mail");
        }

    }

    public String readHtmlFile(String file) {
        try {
            InputStream inputStream = resourceLoader.getResource("classpath:" + file).getInputStream();
            return new String(FileCopyUtils.copyToByteArray(inputStream), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }

    }



}
