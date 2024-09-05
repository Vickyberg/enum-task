package com.example.demo.data.repositories;

import com.example.demo.data.models.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {
    Course findByCourseTitle(String courseTitle);
}
