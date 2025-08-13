package com.wesdell.college_system.interfaces;

import com.wesdell.college_system.exceptions.ResourceNotFoundException;
import com.wesdell.college_system.models.Professor;

import java.util.List;

public interface IProfessorService {
    List<Professor> getProfessors();
    Professor getProfessorById(Long id) throws ResourceNotFoundException;
    Professor createProfessor(Professor newProfessor);
    Professor updateProfessorById(Long id, Professor updatedProfessor) throws ResourceNotFoundException;
    void deleteProfessorById(Long id) throws ResourceNotFoundException;
}
