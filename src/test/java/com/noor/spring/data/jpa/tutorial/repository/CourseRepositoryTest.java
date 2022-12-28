package com.noor.spring.data.jpa.tutorial.repository;

import com.noor.spring.data.jpa.tutorial.entity.Course;
import com.noor.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void findallcourses()
    {
        List<Course> courseList = courseRepository.findAll();
        System.out.println(courseList);
    }

    @Test
    public void saveCoursewithTeacher()
    {
        Teacher teacher = Teacher.builder()
                .firstName("Geeta")
                .lastName("Malhotra")
                .build();


        Course course = Course.builder()
                .title("Python")
                .credit(7)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }
}