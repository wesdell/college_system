package com.wesdell.college_system.interfaces;

import com.wesdell.college_system.models.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getStudents();
    Student getStudentById(Long id);
    Student createStudent(Student newStudent);
    Student updateStudentById(Long id, Student updatedStudent);
    void deleteStudentById(Long id);
}
