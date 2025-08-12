package com.wesdell.college_system.interfaces;

import com.wesdell.college_system.exceptions.ResourceNotFoundException;
import com.wesdell.college_system.models.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getStudents();
    Student getStudentById(Long id) throws ResourceNotFoundException;
    Student createStudent(Student newStudent);
    Student updateStudentById(Long id, Student updatedStudent) throws ResourceNotFoundException;
    void deleteStudentById(Long id) throws ResourceNotFoundException;
}
