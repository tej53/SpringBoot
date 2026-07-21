package com.tej.demo.StudentServer.DTO;

import com.tej.demo.StudentServer.Entity.Student;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateStudentResponseDTO {

    private int id;        // Add

    private String name;
    private int age;
    private String email;
    private String department;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}