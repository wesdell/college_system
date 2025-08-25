package com.wesdell.college_system.services;

import com.wesdell.college_system.exceptions.ResourceNotFoundException;
import com.wesdell.college_system.interfaces.IAssignmentService;
import com.wesdell.college_system.models.Assignment;
import com.wesdell.college_system.models.Grade;
import com.wesdell.college_system.repositories.AssignmentRepository;
import com.wesdell.college_system.repositories.GradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssignmentService implements IAssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final GradeRepository gradeRepository;

    @Override
    public List<Assignment> getAssignments() {
        return assignmentRepository.findAll();
    }

    @Override
    public Assignment getAssignmentById(Long id) throws ResourceNotFoundException {
        return assignmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Assignment", id));
    }

    @Override
    public Assignment createAssignment(Assignment newAssignment) {
        return assignmentRepository.save(newAssignment);
    }

    @Override
    public Assignment updateAssignmentById(Long id, Assignment updatedAssignment) throws ResourceNotFoundException {
        Assignment assignment = getAssignmentById(id);

        assignment.setDescription(updatedAssignment.getDescription());
        assignment.setWeight(updatedAssignment.getWeight());
        assignment.setType(updatedAssignment.getType());

        return assignmentRepository.save(assignment);
    }

    @Override
    public void deleteAssignmentById(Long id) throws ResourceNotFoundException {
        Assignment assignment = getAssignmentById(id);
        assignmentRepository.delete(assignment);
    }

    @Override
    public Assignment addGradeToAssignment(Long id, Long gradeId) throws ResourceNotFoundException {
        Assignment assignment = getAssignmentById(id);
        Grade grade = gradeRepository.findById(gradeId)
                .orElseThrow(() -> new ResourceNotFoundException("Grade", gradeId));

        assignment.getGrades().add(grade);
        return assignmentRepository.save(assignment);
    }

    @Override
    public Assignment removeGradeFromAssignment(Long id, Long gradeId) throws ResourceNotFoundException {
        Assignment assignment = getAssignmentById(id);
        assignment.getGrades().removeIf(grade -> grade.getId().equals(gradeId));
        return assignmentRepository.save(assignment);
    }

}
