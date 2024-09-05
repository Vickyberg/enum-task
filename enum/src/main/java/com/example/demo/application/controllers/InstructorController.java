package com.example.demo.application.controllers;

import com.example.demo.data.models.dtos.requests.InstructorRequest;
import com.example.demo.services.instructor.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/instructor")
@RequiredArgsConstructor
public class InstructorController {
    private final InstructorService instructorService;

    @PostMapping
    public ResponseEntity<?> createInstructor(@RequestBody InstructorRequest instructorRequest) {
        return ResponseEntity.ok(instructorService.createInstructor(instructorRequest));
    }

    @GetMapping
    public ResponseEntity<?> getAllInstructors() {
        return ResponseEntity.ok(instructorService.getAllInstructors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInstructorById(@PathVariable String id) {
        return ResponseEntity.ok(instructorService.getInstructorById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInstructor(@PathVariable String id) {
        return ResponseEntity.ok(instructorService.deleteInstructor(id));
    }

}
