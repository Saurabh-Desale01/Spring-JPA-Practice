package com.practice.springdatajpapractice.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.practice.springdatajpapractice.entity.Course;
import com.practice.springdatajpapractice.entity.CourseMaterial;

@SpringBootTest
class CourseMaterialRepositoryTest {

	@Autowired
	private CourseMaterialRepository courseMaterialRepository;
	
	@Test
	public void saveCourseMaterial() {
		Course course =
                Course.builder()
                .courseTitle(".net")
                .credit(6)
                .build();

        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                .url("www.google.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
	}
	
	 @Test
	    public void printAllCourseMaterials() {
	        List<CourseMaterial> courseMaterials = 
	                courseMaterialRepository.findAll();

	        System.out.println("courseMaterials = " + courseMaterials);
	    }

}
