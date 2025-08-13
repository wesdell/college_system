package com.wesdell.college_system.services;

import com.wesdell.college_system.exceptions.ResourceNotFoundException;
import com.wesdell.college_system.interfaces.IProfessorService;
import com.wesdell.college_system.models.Professor;
import com.wesdell.college_system.repositories.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService implements IProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public List<Professor> getProfessors(){
        return professorRepository.findAll();
    }

    @Override
    public Professor getProfessorById(Long id) throws ResourceNotFoundException {
        return professorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Professor", id));
    }

    @Override
    public Professor createProfessor(Professor newProfessor){
        return professorRepository.save(newProfessor);
    }

    @Override
    public Professor updateProfessorById(Long id, Professor updatedProfessor) throws ResourceNotFoundException {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Professor", id));

            professor.setName(updatedProfessor.getName());
            professor.setLastName(updatedProfessor.getLastName());
            professor.setBirthday(updatedProfessor.getBirthday());
            professor.setGender(updatedProfessor.getGender());
            professor.setFaculty(updatedProfessor.getFaculty());

            return professorRepository.save(professor);
    }

    @Override
    public void deleteProfessorById(Long id){
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Professor", id));
        professorRepository.delete(professor);
    }

}
