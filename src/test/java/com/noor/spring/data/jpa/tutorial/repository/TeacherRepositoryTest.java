package com.noor.spring.data.jpa.tutorial.repository;

import com.noor.spring.data.jpa.tutorial.entity.Course;
import com.noor.spring.data.jpa.tutorial.entity.CourseMaterial;
import com.noor.spring.data.jpa.tutorial.entity.Teacher;
import lombok.Builder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;
    @Test
    public void saveTeacher()
    {
        Course course = Course.builder()
                .title("Pysics")
                .credit(4)
                .build();

        Course course2 = Course.builder()
                .title("English")
                .credit(5)
                .build();

        Teacher teacher  = Teacher.builder()
                .firstName("Mamta")
                .lastName("Sharma")
                //.courses(List.of(course, course2))
                .build();

        teacherRepository.save(teacher);
    }
}