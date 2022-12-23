package com.noor.spring.data.jpa.tutorial.repository;

import com.noor.spring.data.jpa.tutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName( String firstName);

    //public List<Student> findByFirstNameMatchCase( String firstName);

    public List<Student> findByFirstNameContaining (String name);

    @Query("select s from Student s where upper(s.emailId) = upper(?1)")
    List<Student> customfindByEmailIdIgnoreCase(String emailId);

}
