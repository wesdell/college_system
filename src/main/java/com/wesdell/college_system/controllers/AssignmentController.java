package com.wesdell.college_system.controllers;

import com.wesdell.college_system.interfaces.IAssignmentService;
import com.wesdell.college_system.models.Assignment;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/assignments")
public class AssignmentController {

    private final IAssignmentService iAssignmentService;

    public AssignmentController(IAssignmentService iAssignmentService) {
        this.iAssignmentService = iAssignmentService;
    }

    @GetMapping
    public ResponseEntity<List<Assignment>> getAssignments() {
        return new ResponseEntity<>(iAssignmentService.getAssignments(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assignment> getAssignmentById(@PathVariable Long id) {
        return new ResponseEntity<>(iAssignmentService.getAssignmentById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Assignment> createAssignment(@Valid @RequestBody Assignment newAssignment) {
        return new ResponseEntity<>(iAssignmentService.createAssignment(newAssignment), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Assignment> updateAssignment(@PathVariable Long id, @Valid @RequestBody Assignment newAssignment) {
        return new ResponseEntity<>(iAssignmentService.updateAssignmentById(id, newAssignment), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssignment(@PathVariable Long id) {
        iAssignmentService.deleteAssignmentById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/grades/{gradeId}")
    public ResponseEntity<Assignment> addGradeToAssignment(@PathVariable Long id, @PathVariable Long gradeId) {
        return ResponseEntity.ok(iAssignmentService.addGradeToAssignment(id, gradeId));
    }
    
    @DeleteMapping("/{id}/grades/{gradeId}")
    public ResponseEntity<Assignment> removeGradeFromAssignment(@PathVariable Long id, @PathVariable Long gradeId) {
        return ResponseEntity.ok(iAssignmentService.removeGradeFromAssignment(id, gradeId));
    }

}
