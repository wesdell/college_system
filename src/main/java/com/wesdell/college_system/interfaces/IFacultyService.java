package com.wesdell.college_system.interfaces;

import com.wesdell.college_system.models.Faculty;

import java.util.List;

public interface IFacultyService {
    List<Faculty> getFaculties();
    Faculty getFacultyById(Long id);
    void createFaculty(Faculty newFaculty);
    boolean updateFacultyById(Long id, Faculty updatedFaculty);
    boolean deleteFacultyById(Long id);
}
