package com.wesdell.college_system.interfaces;

import com.wesdell.college_system.exceptions.ResourceNotFoundException;
import com.wesdell.college_system.models.College;

import java.util.List;

public interface ICollegeService {
    List<College> getColleges();

    College getCollegeById(Long id) throws ResourceNotFoundException;

    College createCollege(College newCollege);

    College updateCollegeById(Long id, College updatedCollege) throws ResourceNotFoundException;

    void deleteCollegeById(Long id) throws ResourceNotFoundException;
}
