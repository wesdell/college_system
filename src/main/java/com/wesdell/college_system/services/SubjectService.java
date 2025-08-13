package com.wesdell.college_system.services;

import com.wesdell.college_system.exceptions.ResourceNotFoundException;
import com.wesdell.college_system.interfaces.ISubjectService;
import com.wesdell.college_system.models.Subject;
import com.wesdell.college_system.repositories.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService implements ISubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<Subject> getSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject getSubjectById(Long id) throws ResourceNotFoundException {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subject", id));
    }

    @Override
    public Subject createSubject(Subject newSubject) {
        return subjectRepository.save(newSubject);
    }

    @Override
    public Subject updateSubjectById(Long id, Subject updatedSubject) throws ResourceNotFoundException {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subject", id));

        subject.setDescription(updatedSubject.getDescription());
        subject.setName(updatedSubject.getName());
        subject.setCredits(updatedSubject.getCredits());
        subject.setFaculty(updatedSubject.getFaculty());

        return subjectRepository.save(subject);
    }

    @Override
    public void deleteSubjectById(Long id) throws ResourceNotFoundException {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subject", id));
        subjectRepository.delete(subject);
    }

}
