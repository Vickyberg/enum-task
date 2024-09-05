package com.example.demo.services.learner;

import com.example.demo.data.models.dtos.requests.LearnerRequest;
import com.example.demo.data.models.dtos.responses.LearnerResponse;
import com.example.demo.data.models.entities.Learner;

import java.util.List;

public interface LearnerService {

    LearnerResponse addLearner(LearnerRequest learnerRequest);
    List<Learner> getAllLearners();
    LearnerResponse getLearnerById(String id);
}
