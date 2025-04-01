package com.jpa.repository;

import com.jpa.entities.CourseDetail;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<CourseDetail,Long>  {

    @EntityGraph(attributePaths = {"studentDetail"},type = EntityGraph.EntityGraphType.FETCH)
    Optional<CourseDetail> findById(Long id);
}
