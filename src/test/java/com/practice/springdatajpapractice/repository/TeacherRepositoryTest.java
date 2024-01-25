package com.practice.springdatajpapractice.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.practice.springdatajpapractice.entity.Course;
import com.practice.springdatajpapractice.entity.Teacher;

@SpringBootTest
class TeacherRepositoryTest {

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Test
	public void saveTeacher() {
		
		Course courseDSA = Course.builder()
				.courseTitle("DSA")
				.credit(7)
				.build();
		
		Course courseJava = Course.builder()
				.courseTitle("Java")
				.credit(8)
				.build();
		
		Teacher teacher = Teacher.builder()
				.firstName("Rob")
				.lastName("Harvey")
				//.course(List.of(courseDSA, courseJava))
				.build();
		
		teacherRepository.save(teacher);
		
		
	}

}
