package com.wesdell.college_system.services;

import com.wesdell.college_system.interfaces.IFacultyService;
import com.wesdell.college_system.models.Faculty;
import com.wesdell.college_system.repositories.FacultyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public void createFaculty(Faculty newFaculty) {
        facultyRepository.save(newFaculty);
    }

    @Override
    public boolean updateFacultyById(Long id, Faculty updatedFaculty) {
        Optional<Faculty> existingFaculty = facultyRepository.findById(id);
        if (existingFaculty.isPresent()) {
            Faculty faculty = existingFaculty.get();
            faculty.setName(updatedFaculty.getName());
            faculty.setDescription(updatedFaculty.getDescription());
            faculty.setDean(updatedFaculty.getDean());
            faculty.setLocation(updatedFaculty.getLocation());
            facultyRepository.save(faculty);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteFacultyById(Long id) {
        Optional<Faculty> existingFaculty = facultyRepository.findById(id);
        if (existingFaculty.isPresent()) {
            facultyRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
