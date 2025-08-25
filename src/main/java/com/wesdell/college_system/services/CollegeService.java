package com.wesdell.college_system.services;

import com.wesdell.college_system.exceptions.ResourceNotFoundException;
import com.wesdell.college_system.interfaces.ICollegeService;
import com.wesdell.college_system.models.College;
import com.wesdell.college_system.models.Faculty;
import com.wesdell.college_system.repositories.CollegeRepository;
import com.wesdell.college_system.repositories.FacultyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CollegeService implements ICollegeService {

    private final CollegeRepository collegeRepository;
    private final FacultyRepository facultyRepository;

    @Override
    public List<College> getColleges() {
        return collegeRepository.findAll();
    }

    @Override
    public College getCollegeById(Long id) throws ResourceNotFoundException {
        return collegeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("College", id));
    }

    @Override
    public College createCollege(College newCollege) {
        return collegeRepository.save(newCollege);
    }

    @Override
    public College updateCollegeById(Long id, College updatedCollege) throws ResourceNotFoundException {
        College college = getCollegeById(id);
        college.setDescription(updatedCollege.getDescription());
        return collegeRepository.save(college);
    }

    @Override
    public void deleteCollegeById(Long id) throws ResourceNotFoundException {
        College college = getCollegeById(id);
        collegeRepository.delete(college);
    }

    @Override
    public College addFacultyToCollege(Long id, Long facultyId) throws ResourceNotFoundException {
        College college = getCollegeById(id);
        Faculty faculty = facultyRepository.findById(facultyId)
                .orElseThrow(() -> new ResourceNotFoundException("Faculty", facultyId));

        college.getFaculties().add(faculty);
        return collegeRepository.save(college);
    }

    @Override
    public void removeFacultyFromCollege(Long id, Long facultyId) throws ResourceNotFoundException {
        College college = getCollegeById(id);
        college.getFaculties().removeIf(faculty -> faculty.getId().equals(facultyId));
        collegeRepository.save(college);
    }

}
