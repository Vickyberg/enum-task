package com.example.demo.application.controllers;

import com.example.demo.services.invitation.InvitationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/invitation")
@RequiredArgsConstructor
public class InvitationController {

    private final InvitationService invitationService;

    @PostMapping("/{email}/invite")
    public ResponseEntity<?> inviteLearner(@PathVariable String email) {
        return ResponseEntity.ok(invitationService.inviteLearner(email));
    }
}
