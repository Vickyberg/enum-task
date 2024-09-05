package com.example.demo.services.course;

import com.example.demo.data.models.dtos.requests.CreateCourseRequest;
import com.example.demo.data.models.dtos.responses.AssignInstructorResponse;
import com.example.demo.data.models.dtos.responses.CourseResponse;

import java.util.List;

public interface CourseService {

    CourseResponse createCourse(CreateCourseRequest request);
    CourseResponse getCourseById(String id);

    List<CourseResponse> getAllCourses();

    CourseResponse deleteCourse(String id);

    AssignInstructorResponse assignInstructorToCourse(String courseId, String instructorId);

    CourseResponse removeInstructorFromCourse(String courseId, String instructorId);
}
