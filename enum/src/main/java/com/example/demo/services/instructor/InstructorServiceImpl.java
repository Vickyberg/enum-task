package com.example.demo.services.instructor;

import com.example.demo.data.exceptions.EnumException;
import com.example.demo.data.models.dtos.requests.InstructorRequest;
import com.example.demo.data.models.dtos.responses.InstructorResponse;
import com.example.demo.data.models.entities.Instructor;
import com.example.demo.data.repositories.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService{

    private final InstructorRepository instructorRepository;
    private final ModelMapper modelMapper = new ModelMapper();
    @Override
    public InstructorResponse createInstructor(InstructorRequest instructorRequest) {
        Instructor savedInstructor = new Instructor();
        modelMapper.map(instructorRequest, savedInstructor);
        instructorRepository.save(savedInstructor);
        return InstructorResponse.builder()
                .success(true)
                .message("Instructor created successfully")
                .data(savedInstructor)
                .build();
    }

    @Override
    public InstructorResponse deleteInstructor(String id) {

        return instructorRepository.findById(UUID.fromString(id)).map(instructor -> {
            instructorRepository.delete(instructor);
            return InstructorResponse.builder()
                    .success(true)
                    .message("Instructor deleted successfully")
                    .data(instructor)
                    .build();

        }).orElseGet(() -> InstructorResponse.builder()
                .success(false)
                .message("Instructor not found")
                .data(null)
                .build());
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    @Override
    public InstructorResponse getInstructorById(String id) {
        Instructor instructor = instructorRepository.findById(UUID.fromString(id)).orElseThrow(
                () -> new EnumException("Instructor not found"));
        return InstructorResponse.builder()
                .success(true)
                .message("Data retrieved successfully")
                .data(instructor)
                .build();
    }


}
