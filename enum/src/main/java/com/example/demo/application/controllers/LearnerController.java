package com.example.demo.application.controllers;

import com.example.demo.data.models.dtos.requests.LearnerRequest;
import com.example.demo.services.learner.LearnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/learner")
@RequiredArgsConstructor
public class LearnerController {

    private final LearnerService learnerService;

    @PostMapping
    public ResponseEntity<?> createLearner(@RequestBody LearnerRequest learnerRequest) {
        return ResponseEntity.ok(learnerService.addLearner(learnerRequest));
    }

    @GetMapping
    public ResponseEntity<?> getAllLearners() {
        return ResponseEntity.ok(learnerService.getAllLearners());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getLearnerById(@PathVariable String id) {
        return ResponseEntity.ok(learnerService.getLearnerById(id));
    }
}
