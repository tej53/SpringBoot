package com.tej.demo.StudentServer.Repository;

import com.tej.demo.StudentServer.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    boolean existsByEmail(String email);

}