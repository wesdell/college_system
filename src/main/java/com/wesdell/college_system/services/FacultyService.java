package com.wesdell.college_system.services;

import com.wesdell.college_system.exceptions.ResourceNotFoundException;
import com.wesdell.college_system.interfaces.IFacultyService;
import com.wesdell.college_system.models.Faculty;
import com.wesdell.college_system.repositories.FacultyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService implements IFacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public List<Faculty> getFaculties() {
        return facultyRepository.findAll();
    }

    @Override
    public Faculty getFacultyById(Long id) {
        return facultyRepository.findById(id).orElse(null);
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

        return facultyRepository.save(faculty);
    }

    @Override
    public void deleteFacultyById(Long id) throws ResourceNotFoundException {
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Faculty", id));
        facultyRepository.delete(faculty);
    }

}
