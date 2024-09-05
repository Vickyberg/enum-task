package com.example.demo.data.models.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class LearnerRequest {

        private String email;
        private String password;
        private String firstName;
        private String lastName;
        private String phoneNumber;
}
