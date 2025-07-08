package com.wesdell.college_system.repositories;

import com.wesdell.college_system.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    boolean existsByInstitutionalEmail(String institutionalEmail);
}
