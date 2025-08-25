package com.wesdell.college_system.interfaces;

import com.wesdell.college_system.exceptions.ResourceNotFoundException;
import com.wesdell.college_system.models.Career;

import java.util.List;

public interface ICareerService {
    List<Career> getCareers();

    Career getCareerById(Long id) throws ResourceNotFoundException;

    Career createCareer(Career newCareer);

    Career updateCareerById(Long id, Career updatedCareer) throws ResourceNotFoundException;

    void deleteCareerById(Long id) throws ResourceNotFoundException;
}
