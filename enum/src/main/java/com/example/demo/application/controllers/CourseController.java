package com.example.demo.application.controllers;

import com.example.demo.data.models.dtos.requests.CreateCourseRequest;
import com.example.demo.data.models.dtos.responses.CourseResponse;
import com.example.demo.services.course.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseResponse> createCourse(@RequestBody CreateCourseRequest request) {
        return ResponseEntity.ok(courseService.createCourse(request));
    }


    @GetMapping("/{id}")
    public ResponseEntity<CourseResponse> getCourseById(@PathVariable String id) {
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @GetMapping
    public ResponseEntity<List<CourseResponse>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CourseResponse> deleteCourse(@PathVariable String id) {
        return ResponseEntity.ok(courseService.deleteCourse(id));
    }

    @PostMapping("/{courseId}/assign-instructor/{instructorId}")
    public ResponseEntity<?> assignInstructorToCourse(@PathVariable String courseId, @PathVariable String instructorId) {
        return ResponseEntity.ok(courseService.assignInstructorToCourse(courseId, instructorId));
    }

}
