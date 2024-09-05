package com.example.demo.data.models.dtos.responses;

import com.example.demo.data.models.entities.Learner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class LearnerResponse {

    private  boolean success;
    private String message;
    private Learner data;
}
