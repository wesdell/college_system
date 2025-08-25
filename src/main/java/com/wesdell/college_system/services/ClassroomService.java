package com.wesdell.college_system.services;

import com.wesdell.college_system.exceptions.ResourceNotFoundException;
import com.wesdell.college_system.interfaces.IClassroomService;
import com.wesdell.college_system.models.Classroom;
import com.wesdell.college_system.models.Course;
import com.wesdell.college_system.repositories.ClassroomRepository;
import com.wesdell.college_system.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassroomService implements IClassroomService {

    private final ClassroomRepository classroomRepository;
    private final CourseRepository courseRepository;

    @Override
    public List<Classroom> getClassrooms() {
        return classroomRepository.findAll();
    }

    @Override
    public Classroom getClassroomById(Long id) throws ResourceNotFoundException {
        return classroomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Classroom", id));
    }

    @Override
    public Classroom createClassroom(Classroom newClassroom) {
        return classroomRepository.save(newClassroom);
    }

    @Override
    public Classroom updateClassroomById(Long id, Classroom updatedClassroom) throws ResourceNotFoundException {
        Classroom classroom = getClassroomById(id);

        classroom.setRoomNumber(updatedClassroom.getRoomNumber());
        classroom.setLocation(updatedClassroom.getLocation());
        classroom.setCapacity(updatedClassroom.getCapacity());
        classroom.setCourses(updatedClassroom.getCourses());

        return classroomRepository.save(classroom);
    }

    @Override
    public void deleteClassroomById(Long id) throws ResourceNotFoundException {
        Classroom classroom = getClassroomById(id);
        classroomRepository.delete(classroom);
    }

    @Override
    public Classroom addCourseToClassroom(Long id, Long courseId) throws ResourceNotFoundException {
        Classroom classroom = getClassroomById(id);
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course", courseId));

        classroom.getCourses().add(course);
        return classroomRepository.save(classroom);
    }

    @Override
    public void removeCourseFromClassroom(Long id, Long courseId) throws ResourceNotFoundException {
        Classroom classroom = getClassroomById(id);
        classroom.getCourses().removeIf(course -> course.getId().equals(courseId));
        classroomRepository.save(classroom);
    }


}
