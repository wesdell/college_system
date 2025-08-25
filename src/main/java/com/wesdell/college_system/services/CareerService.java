package com.wesdell.college_system.services;

import com.wesdell.college_system.exceptions.ResourceNotFoundException;
import com.wesdell.college_system.interfaces.ICareerService;
import com.wesdell.college_system.models.Career;
import com.wesdell.college_system.models.Subject;
import com.wesdell.college_system.repositories.CareerRepository;
import com.wesdell.college_system.repositories.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CareerService implements ICareerService {

    private final CareerRepository careerRepository;
    private final SubjectRepository subjectRepository;

    @Override
    public List<Career> getCareers() {
        return careerRepository.findAll();
    }

    @Override
    public Career getCareerById(Long id) throws ResourceNotFoundException {
        return careerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Career", id));
    }

    @Override
    public Career createCareer(Career newCareer) {
        return careerRepository.save(newCareer);
    }

    @Override
    public Career updateCareerById(Long id, Career updatedCareer) throws ResourceNotFoundException {
        Career career = getCareerById(id);

        career.setName(updatedCareer.getName());
        career.setDescription(updatedCareer.getDescription());

        return careerRepository.save(career);
    }

    @Override
    public void deleteCareerById(Long id) throws ResourceNotFoundException {
        Career career = getCareerById(id);
        careerRepository.delete(career);
    }

    @Override
    public Career addSubjectToCareer(Long id, Long subjectId) throws ResourceNotFoundException {
        Career career = getCareerById(id);
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new ResourceNotFoundException("Subject", subjectId));

        career.getSubjects().add(subject);
        return careerRepository.save(career);
    }

    @Override
    public void removeSubjectFromCareer(Long id, Long subjectId) throws ResourceNotFoundException {
        Career career = getCareerById(id);
        career.getSubjects().removeIf(subject -> subject.getId().equals(subjectId));
        careerRepository.save(career);
    }

}
