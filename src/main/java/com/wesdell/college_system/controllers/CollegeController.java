package com.wesdell.college_system.controllers;

import com.wesdell.college_system.interfaces.ICollegeService;
import com.wesdell.college_system.models.College;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/colleges")
public class CollegeController {

    private final ICollegeService iCollegeService;

    public CollegeController(ICollegeService iCollegeService) {
        this.iCollegeService = iCollegeService;
    }

    @GetMapping
    public ResponseEntity<List<College>> getColleges() {
        return new ResponseEntity<>(iCollegeService.getColleges(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<College> getCollegeById(@PathVariable Long id) {
        return new ResponseEntity<>(iCollegeService.getCollegeById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<College> createCollege(@Valid @RequestBody College newCollege) {
        return new ResponseEntity<>(iCollegeService.createCollege(newCollege), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<College> updateCollege(@PathVariable Long id, @Valid @RequestBody College newCollege) {
        return new ResponseEntity<>(iCollegeService.updateCollegeById(id, newCollege), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCollege(@PathVariable Long id) {
        iCollegeService.deleteCollegeById(id);
        return ResponseEntity.noContent().build();
    }

}
