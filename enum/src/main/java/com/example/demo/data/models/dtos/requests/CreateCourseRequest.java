package com.example.demo.data.models.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class CreateCourseRequest {
    private String courseTitle;
    private String description;
}
