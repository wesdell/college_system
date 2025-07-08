package com.wesdell.college_system.repositories;

import com.wesdell.college_system.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {
    boolean existsByCode(String code);
}
