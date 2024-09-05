package com.example.demo.data.models.dtos.responses;

import com.example.demo.data.models.entities.Course;
import com.example.demo.data.models.entities.Instructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder

public class AssignInstructorResponse {
    private boolean success;
    private String message;
    private Course courseData;
}
