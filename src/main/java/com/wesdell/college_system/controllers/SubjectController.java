package com.wesdell.college_system.controllers;

import com.wesdell.college_system.interfaces.ISubjectService;
import com.wesdell.college_system.models.Subject;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/subjects")
public class SubjectController {

    private final ISubjectService iSubjectService;

    public SubjectController(ISubjectService iSubjectService) {
        this.iSubjectService = iSubjectService;
    }

    @GetMapping
    public ResponseEntity<List<Subject>> getAllSubjects() {
        return new ResponseEntity<>(iSubjectService.getSubjects(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable Long id) {
        return new ResponseEntity<>(iSubjectService.getSubjectById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Subject> createSubject(@Valid @RequestBody Subject newSubject) {
        return new ResponseEntity<>(iSubjectService.createSubject(newSubject), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subject> updateSubject(@PathVariable Long id, @Valid @RequestBody Subject newSubject) {
        return new  ResponseEntity<>(iSubjectService.updateSubjectById(id, newSubject), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubject(@PathVariable Long id) {
        iSubjectService.deleteSubjectById(id);
        return ResponseEntity.noContent().build();
    }
}
