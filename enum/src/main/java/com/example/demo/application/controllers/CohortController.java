package com.example.demo.application.controllers;


import com.example.demo.data.models.dtos.requests.CohortRequest;
import com.example.demo.data.models.dtos.responses.CohortResponse;
import com.example.demo.data.models.entities.Cohort;
import com.example.demo.services.cohort.CohortService;
import com.github.fge.jsonpatch.JsonPatch;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cohort")
@RequiredArgsConstructor
public class CohortController {
    private final CohortService cohortService;

    @PostMapping
    public ResponseEntity<CohortResponse> createCohort(@RequestBody CohortRequest request) {
        return ResponseEntity.ok(cohortService.createCohort(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CohortResponse> getCohortById(@PathVariable String id) {
        return ResponseEntity.ok(cohortService.getCohortById(id));
    }

    @GetMapping
    public ResponseEntity<List<Cohort>> getAllCohorts() {
        return ResponseEntity.ok(cohortService.getAllCohorts());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateCohort(@PathVariable String id, @RequestBody JsonPatch jsonPatch) {
        return ResponseEntity.ok(cohortService.updateCohort(id, jsonPatch));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CohortResponse> deleteCohort(@PathVariable String id) {
        return ResponseEntity.ok(cohortService.deleteCohort(id));
    }

    @PostMapping("/{cohortId}/{learnerId}/send-invitation")
    public ResponseEntity<?> addLearner(@PathVariable  String cohortId, @PathVariable String learnerId) {
        return ResponseEntity.ok(cohortService.addLearnerToCohort(cohortId, learnerId));
    }
}

