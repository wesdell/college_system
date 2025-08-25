package com.wesdell.college_system.interfaces;

import com.wesdell.college_system.exceptions.ResourceNotFoundException;
import com.wesdell.college_system.models.Grade;

import java.util.List;

public interface IGradeService {
    List<Grade> getGrades();

    Grade getGradeById(Long id) throws ResourceNotFoundException;

    Grade createGrade(Grade newGrade);

    Grade updateGradeById(Long id, Grade updatedGrade) throws ResourceNotFoundException;

    void deleteGradeById(Long id) throws ResourceNotFoundException;
}
