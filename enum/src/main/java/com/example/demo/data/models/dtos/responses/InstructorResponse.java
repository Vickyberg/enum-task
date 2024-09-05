package com.example.demo.data.models.dtos.responses;

import com.example.demo.data.models.entities.Instructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class InstructorResponse {
    private boolean success;
    private String message;
    private Instructor data;
}
