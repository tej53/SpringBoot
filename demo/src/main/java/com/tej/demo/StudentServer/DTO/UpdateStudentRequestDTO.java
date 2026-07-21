package com.tej.demo.StudentServer.DTO;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class UpdateStudentRequestDTO {

    private String name;
    private int age;
    private String email;      // Add
    private String department;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}