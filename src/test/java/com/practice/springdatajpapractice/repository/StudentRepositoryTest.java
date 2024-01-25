package com.practice.springdatajpapractice.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.practice.springdatajpapractice.entity.Guardian;
import com.practice.springdatajpapractice.entity.Student;

@SpringBootTest
class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;

//	@Test
//	void saveStudent() {
//		
//		Student student = Student.builder()
//				.emailId("testuser@gmail.com")
//				.firstName("Test")
//				.lastName("User")
//				//.guardianName("TestGuardian")
//				//.guardianEmail("test.guardian@gmail.com")
//				//.guardianMobile("9999999999")
//				.build();
//		
//		studentRepository.save(student);
//	}
	
	@Test
	public void saveStudentWithGuardianDetails() {
		
		Guardian guardian = Guardian.builder()
				.email("demo.guardian@gmail.com")
				.name("DemoGuardian")
				.mobile("8888888888")
				.build();
		
		Student student = Student.builder()
				.emailId("demouser1@gmail.com")
				.firstName("Demo")
				.lastName("User")
				.guardian(guardian)
				.build();
				
		studentRepository.save(student);
	}
	
	@Test
	public void getAllStudents() {
		
		List<Student> studentList = studentRepository.findAll();
		System.out.println(studentList);
	}
	
	@Test
    public void printStudentByFirstName() {
        
        List<Student> students =
                studentRepository.findByFirstName("demo");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining() {

        List<Student> students =
                studentRepository.findByFirstNameContaining("de");

        System.out.println("students = " + students);
    }
    
    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students =
                studentRepository.findByGuardianName("DemoGuardian");
        System.out.println("students = " + students);
    }

    @Test
    public void printgetStudentByEmailAddress() {
        Student student =
                studentRepository.getStudentByEmailAddress(
                        "testuser@gmail.com"
                );

        System.out.println("student = " + student);
    }

    @Test
    public void printgetStudentFirstNameByEmailAddress() {
        String firstName =
                studentRepository.getStudentFirstNameByEmailAddress(
                        "testuser@gmail.com"
                );
        System.out.println("firstName = " + firstName);
    }
    
    @Test
    public void printgetStudentByEmailAddressNative(){
        Student student =
                studentRepository.getStudentByEmailAddressNative(
                        "testuser@gmail.com"
                );

        System.out.println("student = " + student);
    }

    @Test
    public void printgetStudentByEmailAddressNativeNamedParam() {
        Student student =
                studentRepository.getStudentByEmailAddressNativeNamedParam(
                        "testuser@gmail.com"
                );

        System.out.println("student = " + student);
    }

    @Test
    public void updateStudentNameByEmailIdTest() {
        studentRepository.updateStudentNameByEmailId(
                "Test2",
                "testuser@gmail.com");
    }


}
