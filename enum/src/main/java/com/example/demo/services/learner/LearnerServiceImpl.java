package com.example.demo.services.learner;

import com.example.demo.data.exceptions.EnumException;
import com.example.demo.data.models.dtos.requests.LearnerRequest;
import com.example.demo.data.models.dtos.responses.LearnerResponse;
import com.example.demo.data.models.entities.Learner;
import com.example.demo.data.repositories.LearnerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LearnerServiceImpl implements LearnerService{

    private final LearnerRepository learnerRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public LearnerResponse addLearner(LearnerRequest learnerRequest) {

        Learner learner = new Learner();
        modelMapper.map(learnerRequest, learner);
        learnerRepository.save(learner);

        return LearnerResponse.builder()
                .success(true)
                .message("Learner added successfully")
                .data(learner)
                .build();
    }

    @Override
    public List<Learner> getAllLearners() {
        return learnerRepository.findAll();
    }

    @Override
    public LearnerResponse getLearnerById(String id) {
        Learner learner = learnerRepository.findById(UUID.fromString(id)).orElseThrow(
                () ->    new   EnumException("Learner not found"));
        return LearnerResponse.builder()
                .success(true)
                .message("Learner retrieved successfully")
                .data(learner)
                .build();
    }
}
