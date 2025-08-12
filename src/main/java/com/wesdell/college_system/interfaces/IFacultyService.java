package com.wesdell.college_system.interfaces;

import com.wesdell.college_system.exceptions.ResourceNotFoundException;
import com.wesdell.college_system.models.Faculty;

import java.util.List;

public interface IFacultyService {
    List<Faculty> getFaculties();
    Faculty getFacultyById(Long id) throws ResourceNotFoundException;
    Faculty createFaculty(Faculty newFaculty);
    Faculty updateFacultyById(Long id, Faculty updatedFaculty) throws ResourceNotFoundException;
    void deleteFacultyById(Long id) throws ResourceNotFoundException;
}
