package com.wesdell.college_system.services;

import com.wesdell.college_system.exceptions.ResourceNotFoundException;
import com.wesdell.college_system.interfaces.IFacultyService;
import com.wesdell.college_system.models.Faculty;
import com.wesdell.college_system.repositories.FacultyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacultyService implements IFacultyService {

    private final FacultyRepository facultyRepository;

    @Override
    public List<Faculty> getFaculties() {
        return facultyRepository.findAll();
    }

    @Override
    public Faculty getFacultyById(Long id) throws ResourceNotFoundException {
        return facultyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Faculty", id));
    }

    @Override
    public Faculty createFaculty(Faculty newFaculty) {
        return facultyRepository.save(newFaculty);
    }

    @Override
    public Faculty updateFacultyById(Long id, Faculty updatedFaculty) throws ResourceNotFoundException {
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Faculty", id));

        faculty.setDescription(updatedFaculty.getDescription());
        faculty.setDean(updatedFaculty.getDean());
        faculty.setLocation(updatedFaculty.getLocation());
        faculty.setCollege(updatedFaculty.getCollege());
        faculty.setCareers(updatedFaculty.getCareers());

        return facultyRepository.save(faculty);
    }

    @Override
    public void deleteFacultyById(Long id) throws ResourceNotFoundException {
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Faculty", id));
        facultyRepository.delete(faculty);
    }

}
