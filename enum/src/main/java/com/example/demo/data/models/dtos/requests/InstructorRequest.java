package com.example.demo.data.models.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class InstructorRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
}
