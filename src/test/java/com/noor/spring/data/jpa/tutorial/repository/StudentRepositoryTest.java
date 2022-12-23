package com.noor.spring.data.jpa.tutorial.repository;

import com.noor.spring.data.jpa.tutorial.entity.Guardian;
import com.noor.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    Student student = Student.builder()
            .emailId("deol@gmail.com")
            .firstName("Someone")
            .lastName("Singh")
//            .guardianName("Vadaa")
//            .guardianEmail("vd@thanedar.com")
//            .guardianMobile("890890890")
            .build();

    Guardian guardingJ = new Guardian("Baapu", "ng@yahoo.ca", "987987987");

    Student student2 = Student.builder()
            .firstName("Jarnail")
            .emailId("jarnails@yh.ca")
            .lastName("singh")
            .guardian(guardingJ)
            .build();

    //Why do I have to put in a long value when it's not required in the builder way?
    //Student student3 = new Student(2L,"Jarnail", "singh", "jarnails@yh.ca", guardinJ);

    @Disabled
    @Test
    public void saveStudent()
    {
        studentRepository.save(student);
    }

    @Test
    public void saveStudentwithGuardian()
    {
        studentRepository.save(student2);
    }

    @Test
    public void findAllStudents()
    {
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    public void findByFirstName()
    {
        List<Student> studentList = studentRepository.findByFirstName("jarnail");
        System.out.println(studentList);
    }

    @Test
    public void findByFirstNameContaining()
    {
        List<Student> studentList = studentRepository.findByFirstNameContaining("n");
        System.out.println(studentList);
    }

    @Test
    public void findByEmailid()
    {
        List<Student> studentList = studentRepository.customfindByEmailIdIgnoreCase("deol@gmail.com");
        System.out.println(studentList);
    }

    @Test
    public void updateStudentNameByEmailId()
    {
        studentRepository.updateStudentNameByEmailId("Gurnoor", "deol@gmail.com");
    }

}