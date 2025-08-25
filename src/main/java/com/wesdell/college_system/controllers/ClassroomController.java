package com.wesdell.college_system.controllers;

import com.wesdell.college_system.interfaces.IClassroomService;
import com.wesdell.college_system.models.Classroom;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/classrooms")
public class ClassroomController {

    private final IClassroomService iClassroomService;

    public ClassroomController(IClassroomService iClassroomService) {
        this.iClassroomService = iClassroomService;
    }

    @GetMapping
    public ResponseEntity<List<Classroom>> getClassrooms() {
        return new ResponseEntity<>(iClassroomService.getClassrooms(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Classroom> getClassroomById(@PathVariable Long id) {
        return new ResponseEntity<>(iClassroomService.getClassroomById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Classroom> createClassroom(@Valid @RequestBody Classroom newClassroom) {
        return new ResponseEntity<>(iClassroomService.createClassroom(newClassroom), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Classroom> updateClassroom(@PathVariable Long id, @Valid @RequestBody Classroom newClassroom) {
        return new ResponseEntity<>(iClassroomService.updateClassroomById(id, newClassroom), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClassroom(@PathVariable Long id) {
        iClassroomService.deleteClassroomById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/courses/{courseId}")
    public ResponseEntity<Classroom> addCourseToClassroom(@PathVariable Long id, @PathVariable Long courseId) {
        return new ResponseEntity<>(iClassroomService.addCourseToClassroom(id, courseId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/courses/{courseId}")
    public ResponseEntity<Void> removeCourseFromClassroom(@PathVariable Long id, @PathVariable Long courseId) {
        iClassroomService.removeCourseFromClassroom(id, courseId);
        return ResponseEntity.noContent().build();
    }

}
