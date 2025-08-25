package com.wesdell.college_system.interfaces;

import com.wesdell.college_system.exceptions.ResourceNotFoundException;
import com.wesdell.college_system.models.Enrollment;

import java.util.List;

public interface IEnrollmentService {
    List<Enrollment> getEnrollments();

    Enrollment getEnrollmentById(Long id) throws ResourceNotFoundException;

    Enrollment createEnrollment(Enrollment newEnrollment);

    Enrollment updateEnrollmentById(Long id, Enrollment updatedEnrollment) throws ResourceNotFoundException;

    void deleteEnrollmentById(Long id) throws ResourceNotFoundException;
}
