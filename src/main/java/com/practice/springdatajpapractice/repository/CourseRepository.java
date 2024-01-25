package com.practice.springdatajpapractice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.springdatajpapractice.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

	Page<Course> findByCourseTitleContaining(
            String title,
            Pageable pageable);

}
