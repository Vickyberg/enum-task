package com.example.demo.data.models.dtos.responses;

import com.example.demo.data.models.entities.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class CourseResponse {

    private boolean success;
    private String message;
    private Course data;
}
