package com.wesdell.college_system.interfaces;

import com.wesdell.college_system.exceptions.ResourceNotFoundException;
import com.wesdell.college_system.models.Subject;

import java.util.List;

public interface ISubjectService {
    List<Subject> getSubjects();
    Subject getSubjectById(Long id) throws ResourceNotFoundException;
    Subject createSubject(Subject newSubject);
    Subject updateSubjectById(Long id, Subject updatedSubject) throws ResourceNotFoundException;
    void deleteSubjectById(Long id) throws ResourceNotFoundException;
}
