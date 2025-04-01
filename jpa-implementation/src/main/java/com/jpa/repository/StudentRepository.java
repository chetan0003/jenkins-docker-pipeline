package com.jpa.repository;

import com.jpa.entities.CourseDetail;
import com.jpa.entities.StudentDetail;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentDetail,Long> {

    @EntityGraph(attributePaths = {"courseDetail"},type = EntityGraph.EntityGraphType.FETCH)
    Optional<StudentDetail> findById(Long id);
}
