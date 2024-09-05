package com.example.demo.services.cohort;

import com.example.demo.data.models.dtos.requests.CohortRequest;
import com.example.demo.data.models.dtos.responses.CohortResponse;
import com.example.demo.data.models.dtos.responses.UpdateCohortResponse;
import com.example.demo.data.models.entities.Cohort;
import com.github.fge.jsonpatch.JsonPatch;

import java.util.List;

public interface CohortService {

    CohortResponse createCohort(CohortRequest cohortRequest);
    CohortResponse getCohortById(String id);

    List<Cohort> getAllCohorts();
    UpdateCohortResponse updateCohort(String id, JsonPatch jsonPatch);

    CohortResponse deleteCohort(String id);

    CohortResponse addLearnerToCohort(String cohortId, String learnerId);



}
