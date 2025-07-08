package com.wesdell.college_system.repositories;

import com.wesdell.college_system.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor,Long> {
    boolean existsByInstitutionalEmail(String institutionalEmail);
}
