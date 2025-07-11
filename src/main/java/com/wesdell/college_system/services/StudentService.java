package com.wesdell.college_system.services;

import com.wesdell.college_system.interfaces.IStudentService;
import com.wesdell.college_system.models.Student;
import com.wesdell.college_system.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService implements IStudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id){
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void createStudent(Student newStudent){
        studentRepository.save(newStudent);
    }

    @Override
    public boolean updateStudentById(Long id, Student updatedStudent){
        Optional<Student> existingStudent = studentRepository.findById(id);
        if(existingStudent.isPresent()){
            Student student = existingStudent.get();
            student.setName(updatedStudent.getName());
            student.setLastName(updatedStudent.getLastName());
            student.setBirthday(updatedStudent.getBirthday());
            student.setGender(updatedStudent.getGender());
            student.setFaculty(updatedStudent.getFaculty());
            studentRepository.save(student);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteStudentById(Long id){
        Optional<Student> existingStudent = studentRepository.findById(id);
        if(existingStudent.isPresent()){
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
