package com.wesdell.college_system.interfaces;

import com.wesdell.college_system.exceptions.ResourceNotFoundException;
import com.wesdell.college_system.models.Course;

import java.util.List;

public interface ICourseService {
    List<Course> getCourses();

    Course getCourseById(Long id) throws ResourceNotFoundException;

    Course createCourse(Course newCourse);

    Course updateCourseById(Long id, Course updatedCourse) throws ResourceNotFoundException;

    void deleteCourseById(Long id) throws ResourceNotFoundException;
}
