package com.noor.spring.data.jpa.tutorial.repository;

import com.noor.spring.data.jpa.tutorial.entity.Course;
import com.noor.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import org.springframework.data.domain.Pageable;
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

    @Test
    public void findAllPagination(){



        Pageable firstPageThreeRecords = PageRequest.of(0,3);
        Pageable secondPageTwoRecords = PageRequest.of(1, 2);

        List<Course> courses = courseRepository.findAll(firstPageThreeRecords).getContent();

        long totalElements = courseRepository.findAll(firstPageThreeRecords).getTotalElements();

        long totalPages = courseRepository.findAll(firstPageThreeRecords).getTotalPages();

        System.out.println("Total Elements:" + totalElements);
        System.out.println("Total Pages:" + totalPages);
        System.out.println(courses);


    }

    public void findAlLSorting()
    {
        Pageable sortByTitle = PageRequest.of(0,2,Sort.by("Title"));

        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();

        System.out.println("courses = " + courses);

    }


    @Test
    public void findByTitleConataing()
    {
        Pageable firstPageTenRecords = PageRequest.of(0,10);
        List<Course> courses = courseRepository.findByTitleContaining("P", firstPageTenRecords);

        System.out.println("courses = " + courses);
    }

}