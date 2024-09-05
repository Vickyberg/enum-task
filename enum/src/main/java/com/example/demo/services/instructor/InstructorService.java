package com.example.demo.services.instructor;

import com.example.demo.data.models.dtos.requests.InstructorRequest;
import com.example.demo.data.models.dtos.responses.InstructorResponse;
import com.example.demo.data.models.dtos.responses.InvitationResponse;
import com.example.demo.data.models.entities.Instructor;

import java.util.List;

public interface InstructorService {

    InstructorResponse createInstructor(InstructorRequest instructorRequest);

    InstructorResponse deleteInstructor(String id);


    List<Instructor> getAllInstructors();

    InstructorResponse getInstructorById(String id);
}
