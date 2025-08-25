package com.wesdell.college_system.interfaces;

import com.wesdell.college_system.exceptions.ResourceNotFoundException;
import com.wesdell.college_system.models.Classroom;

import java.util.List;

public interface IClassroomService {

    List<Classroom> getClassrooms();

    Classroom getClassroomById(Long id) throws ResourceNotFoundException;

    Classroom createClassroom(Classroom newClassroom);

    Classroom updateClassroomById(Long id, Classroom updatedClassroom) throws ResourceNotFoundException;

    void deleteClassroomById(Long id) throws ResourceNotFoundException;

    Classroom addCourseToClassroom(Long id, Long courseId) throws ResourceNotFoundException;

    void removeCourseFromClassroom(Long id, Long courseId) throws ResourceNotFoundException;

}
