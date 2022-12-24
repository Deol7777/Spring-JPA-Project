package com.noor.spring.data.jpa.tutorial.repository;

import com.noor.spring.data.jpa.tutorial.entity.Course;
import com.noor.spring.data.jpa.tutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {




    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    Course course = Course.builder()
            .title("Maths Course")
            .credit(3)
            .build();

    CourseMaterial courseMaterial = CourseMaterial.builder()
            .url("sfdsdf#gmail.com")
            .course(course).
            build();

    @Test
    public void saveData()
    {
        courseMaterialRepository.save(courseMaterial);
        //System.out.println(courseMaterial1);

    }

    @Test
    public void displayCourseMaterial()
    {
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println(courseMaterials);
    }


}