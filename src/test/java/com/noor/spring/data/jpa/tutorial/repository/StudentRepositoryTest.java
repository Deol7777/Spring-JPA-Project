package com.noor.spring.data.jpa.tutorial.repository;

import com.noor.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    Student student = Student.builder()
            .emailId("deol@gmail.com")
            .firstName("Someone")
            .lastName("Singh")
            .guardianName("Vadaa")
            .guardianEmail("vd@thanedar.com")
            .guardianMobile("890890890")
            .build();

    @Disabled
    @Test
    public void saveStudent()
    {
        studentRepository.save(student);
    }

    @Test
    public void findAllStudents()
    {
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }


}