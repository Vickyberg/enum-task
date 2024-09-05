package com.example.demo.services.course;

import com.example.demo.data.exceptions.EnumException;
import com.example.demo.data.models.dtos.requests.CreateCourseRequest;
import com.example.demo.data.models.dtos.responses.AssignInstructorResponse;
import com.example.demo.data.models.dtos.responses.CourseResponse;
import com.example.demo.data.models.entities.Course;
import com.example.demo.data.models.entities.Instructor;
import com.example.demo.data.repositories.CourseRepository;
import com.example.demo.data.repositories.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    private final InstructorRepository instructorRepository;
    @Override
    public CourseResponse createCourse(CreateCourseRequest request) {
     Course   course = new Course();
        modelMapper.map(request, course);
        courseRepository.save(course);
        return CourseResponse.builder()
                .success(true)
                .message("Course created successfully")
                .data(course)
                .build();
    }

    @Override
    public CourseResponse getCourseById(String id) {
        return courseRepository.findById(UUID.fromString(id)).map(course -> CourseResponse.builder()
                .success(true)
                .message("Data retrieved successfully")
                .data(course)
                .build()).orElseGet(() -> CourseResponse.builder()
                .success(false)
                .message("Course not found")
                .data(null)
                .build());
    }

    @Override
    public List<CourseResponse> getAllCourses() {

        return courseRepository.findAll().stream().map(course -> CourseResponse.builder()
                .success(true)
                .message("Data retrieved successfully")
                .data(course)
                .build()).toList();
    }

    @Override
    public CourseResponse deleteCourse(String id) {

 return courseRepository.findById(UUID.fromString(id)).map(course -> {
            courseRepository.delete(course);
            return CourseResponse.builder()
                    .success(true)
                    .message("Course deleted successfully")
                    .data(course)
                    .build();

        }).orElseGet(() -> CourseResponse.builder()
                .success(false)
                .message("Course not found")
                .data(null)
                .build());
    }

    @Override
    public AssignInstructorResponse assignInstructorToCourse(String courseId, String instructorId) {
        Course course = courseRepository.findById(UUID.fromString(courseId)).orElseThrow(()->
                new EnumException("Course does not exist"));

        Instructor instructor = instructorRepository.findById(UUID.fromString(instructorId))
                .orElseThrow(() -> new EnumException("Instructor does not exist"));

        course.setInstructor(instructor);
        courseRepository.save(course);
        return AssignInstructorResponse.builder()
                .success(true)
                .message("Instructor assigned to course successfully")
                .courseData(course)
                .build();
    }

    @Override
    public CourseResponse removeInstructorFromCourse(String courseId, String instructorId) {

        Course course = courseRepository.findById(UUID.fromString(courseId)).orElseThrow(()->
                new EnumException("Course does not exist"));

 instructorRepository.findById(UUID.fromString(instructorId))
                .orElseThrow(() -> new EnumException("Instructor does not exist"));

        course.setInstructor(null);
        courseRepository.save(course);
        return CourseResponse.builder()
                .success(true)
                .message("Instructor removed from course successfully")
                .data(course)
                .build();
    }
}
