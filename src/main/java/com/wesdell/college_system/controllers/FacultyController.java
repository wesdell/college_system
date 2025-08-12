package com.wesdell.college_system.controllers;

import com.wesdell.college_system.interfaces.IFacultyService;
import com.wesdell.college_system.models.Faculty;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/faculties")
public class FacultyController {

    private final IFacultyService iFacultyService;

    public FacultyController(IFacultyService iFacultyService) {
        this.iFacultyService = iFacultyService;
    }

    @GetMapping
    public ResponseEntity<List<Faculty>> getFaculties() {
        return new ResponseEntity<>(iFacultyService.getFaculties(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Faculty> getFacultyById(@PathVariable Long id) {
        return new ResponseEntity<>(iFacultyService.getFacultyById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Faculty> createFaculty(@Valid @RequestBody Faculty newFaculty) {
        return new ResponseEntity<>(iFacultyService.createFaculty(newFaculty), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Faculty> updateFaculty(@PathVariable Long id, @Valid @RequestBody Faculty newFaculty) {
        return new ResponseEntity<>(iFacultyService.updateFacultyById(id, newFaculty), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable Long id) {
        iFacultyService.deleteFacultyById(id);
        return ResponseEntity.noContent().build();
    }

}
