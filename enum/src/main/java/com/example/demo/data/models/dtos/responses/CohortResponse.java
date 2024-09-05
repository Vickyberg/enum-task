package com.example.demo.data.models.dtos.responses;

import com.example.demo.data.models.entities.Cohort;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Data
public class CohortResponse {
    private  boolean success;
    private  String message;
    private Cohort data;
}
