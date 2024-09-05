package com.example.demo.data.models.dtos.requests;

import com.example.demo.data.models.enums.Program;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class CohortRequest {
    private  String cohortName;
    private String description;
    private Program program;
    private LocalDate startDate;
    private LocalDate endDate;
    private String cohortAvatarUrl;
}
