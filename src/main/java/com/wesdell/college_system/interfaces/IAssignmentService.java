package com.wesdell.college_system.interfaces;

import com.wesdell.college_system.exceptions.ResourceNotFoundException;
import com.wesdell.college_system.models.Assignment;

import java.util.List;

public interface IAssignmentService {

    List<Assignment> getAssignments();

    Assignment getAssignmentById(Long id) throws ResourceNotFoundException;

    Assignment createAssignment(Assignment newAssignment);

    Assignment updateAssignmentById(Long id, Assignment updatedAssignment) throws ResourceNotFoundException;

    void deleteAssignmentById(Long id) throws ResourceNotFoundException;

    Assignment addGradeToAssignment(Long assignmentId, Long gradeId) throws ResourceNotFoundException;

    void removeGradeFromAssignment(Long assignmentId, Long gradeId) throws ResourceNotFoundException;

}
