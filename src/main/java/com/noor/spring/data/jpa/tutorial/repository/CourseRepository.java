package com.noor.spring.data.jpa.tutorial.repository;

import com.noor.spring.data.jpa.tutorial.entity.Course;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByTitleContaining(String title, Pageable pageable);
}
