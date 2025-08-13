package com.wesdell.college_system.controllers;

import com.wesdell.college_system.interfaces.IProfessorService;
import com.wesdell.college_system.models.Professor;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/professors")
public class ProfessorController {

    private final IProfessorService iProfessorService;

    public ProfessorController(IProfessorService iProfessorService) {
        this.iProfessorService = iProfessorService;
    }

    @GetMapping
    public ResponseEntity<List<Professor>> getAllProfessors() {
        return new ResponseEntity<>(iProfessorService.getProfessors(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable Long id) {
        return new ResponseEntity<>(iProfessorService.getProfessorById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Professor> createProfessor(@Valid @RequestBody Professor newProfessor) {
        return new ResponseEntity<>(iProfessorService.createProfessor(newProfessor), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> updateProfessor(@PathVariable Long id, @Valid @RequestBody Professor newProfessor) {
        return new ResponseEntity<>(iProfessorService.updateProfessorById(id, newProfessor), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfessor(@PathVariable Long id) {
        iProfessorService.deleteProfessorById(id);
        return ResponseEntity.noContent().build();
    }
}
