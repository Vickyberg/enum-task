package com.example.demo.services.cohort;

import com.example.demo.data.exceptions.EnumException;
import com.example.demo.data.models.dtos.requests.CohortRequest;
import com.example.demo.data.models.dtos.responses.CohortResponse;
import com.example.demo.data.models.dtos.responses.InvitationResponse;
import com.example.demo.data.models.dtos.responses.UpdateCohortResponse;
import com.example.demo.data.models.entities.Cohort;
import com.example.demo.data.models.entities.Learner;
import com.example.demo.data.repositories.CohortRepository;
import com.example.demo.data.repositories.InstructorRepository;
import com.example.demo.data.repositories.InvitationRepository;
import com.example.demo.data.repositories.LearnerRepository;
import com.example.demo.services.invitation.InvitationService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class CohortServiceImpl implements CohortService {

    private final CohortRepository cohortRepository;
    private final ModelMapper modelMapper = new ModelMapper();
    private final ObjectMapper objectMapper = new ObjectMapper();
private final InvitationService invitationService;
private final LearnerRepository learnerRepository;
    @Override
    public CohortResponse createCohort(CohortRequest cohortRequest) {
        Cohort cohort = new Cohort();
        modelMapper.map(cohortRequest, cohort);
        cohortRepository.save(cohort);
        return CohortResponse.builder()
                .success(true)
                .message("Cohort created successfully")
                .data(cohort)
                .build();
    }

    @Override
    public CohortResponse getCohortById(String id) {
        Cohort cohort = cohortRepository.findById(UUID.fromString(id)).orElseThrow(
                () -> new EnumException("Cohort not found"));
        return CohortResponse.builder()
                .success(true)
                .message("Data retrieved successfully")
                .data(cohort)
                .build();

    }

    @Override
    public List<Cohort> getAllCohorts() {
        return cohortRepository.findAll().stream().map(cohort -> CohortResponse.builder()
                .success(true)
                .message("Data retrieved successfully")
                .data(cohort)
                .build().getData()).toList();
    }

    @Override
    public UpdateCohortResponse updateCohort(String id, JsonPatch jsonPatch) {
        Cohort foundCohort = cohortRepository.findById(UUID.fromString(id)).orElseThrow(
                () -> new EnumException("Cohort not found"));
        Cohort updatedCohort = applyPatchToCohort(jsonPatch, foundCohort);
        Cohort savedCourt = cohortRepository.save(updatedCohort);
        return buildCohortUpdatedSuccessfully(savedCourt);
    }

    private static UpdateCohortResponse buildCohortUpdatedSuccessfully(Cohort savedCourt) {
        return UpdateCohortResponse.builder()
                .success(true)
                .message("Cohort updated successfully")
                .data(savedCourt)
                .build();
    }

    private Cohort applyPatchToCohort(JsonPatch jsonPatch, Cohort foundCohort) {
        JsonNode cohortNode = objectMapper.convertValue(foundCohort, JsonNode.class);
        JsonNode patchedCohortNode;
        try {
            patchedCohortNode = jsonPatch.apply(cohortNode);
            return objectMapper.readValue(objectMapper.writeValueAsBytes(patchedCohortNode), Cohort.class);
        } catch (IOException | JsonPatchException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public CohortResponse deleteCohort(String id) {

        return cohortRepository.findById(UUID.fromString(id)).map(cohort -> {
            cohortRepository.delete(cohort);
            return CohortResponse.builder()
                    .success(true)
                    .message("Cohort deleted successfully")
                    .data(cohort)
                    .build();

        }).orElseGet(() -> CohortResponse.builder()
                .success(false)
                .message("Cohort not found")
                .data(null)
                .build());
    }


    @Override
    public CohortResponse addLearnerToCohort(String cohortId, String learnerId) {
        Cohort cohort = cohortRepository.findById(UUID.fromString(cohortId))
                .orElseThrow(() -> new EnumException("Cohort not found for ID: " + cohortId));
        Learner learner = learnerRepository.findById(UUID.fromString(learnerId))
                .orElseThrow(() -> new EnumException("Learner not found for ID: " + learnerId));
        try {
            InvitationResponse invitationResponse = invitationService.inviteLearner(learner.getEmail());
            if (invitationResponse.isSuccess()) {
                log.info("Learner invited successfully: " + invitationResponse.getMessage());
                return CohortResponse.builder()
                        .success(true)
                        .message("Learner " + learner.getEmail() + " invited to cohort " + cohort.getCohortName())
                        .build();
            } else {
                return CohortResponse.builder()
                        .success(false)
                        .message("Failed to invite learner: " + invitationResponse.getMessage())
                        .build();
            }
        } catch (Exception e) {
            return CohortResponse.builder()
                    .success(false)
                    .message("Error while adding learner to cohort: " + e.getMessage())
                    .build();
        }
    }


}
