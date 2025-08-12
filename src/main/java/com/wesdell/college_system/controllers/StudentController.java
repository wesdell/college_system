package com.wesdell.college_system.controllers;

import com.wesdell.college_system.interfaces.IStudentService;
import com.wesdell.college_system.models.Student;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private final IStudentService istudentService;

    public StudentController(IStudentService istudentService) {
        this.istudentService = istudentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(istudentService.getStudents(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return new ResponseEntity<>(istudentService.getStudentById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student newStudent) {
        return new ResponseEntity<>(istudentService.createStudent(newStudent), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @Valid @RequestBody Student newStudent) {
        return new ResponseEntity<>(istudentService.updateStudentById(id, newStudent), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        istudentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }
}
