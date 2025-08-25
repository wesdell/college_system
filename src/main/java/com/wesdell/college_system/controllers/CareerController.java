package com.wesdell.college_system.controllers;

import com.wesdell.college_system.interfaces.ICareerService;
import com.wesdell.college_system.models.Career;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/careers")
public class CareerController {

    private final ICareerService iCareerService;

    public CareerController(ICareerService iCareerService) {
        this.iCareerService = iCareerService;
    }

    @GetMapping
    public ResponseEntity<List<Career>> getCareers() {
        return new ResponseEntity<>(iCareerService.getCareers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Career> getCareerById(@PathVariable Long id) {
        return new ResponseEntity<>(iCareerService.getCareerById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Career> createCareer(@Valid @RequestBody Career newCareer) {
        return new ResponseEntity<>(iCareerService.createCareer(newCareer), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Career> updateCareer(@PathVariable Long id, @Valid @RequestBody Career newCareer) {
        return new ResponseEntity<>(iCareerService.updateCareerById(id, newCareer), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCareer(@PathVariable Long id) {
        iCareerService.deleteCareerById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/subjects/{subjectId}")
    public ResponseEntity<Career> addSubjectToCareer(@PathVariable Long id, @PathVariable Long subjectId) {
        return ResponseEntity.ok(iCareerService.addSubjectToCareer(id, subjectId));
    }

    @DeleteMapping("/{id}/subjects/{subjectId}")
    public ResponseEntity<Career> removeSubjectFromCareer(@PathVariable Long id, @PathVariable Long subjectId) {
        return ResponseEntity.ok(iCareerService.removeSubjectFromCareer(id, subjectId));
    }

}
