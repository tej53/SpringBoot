package com.tej.demo.StudentServer.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class UpdateStudentResponseDTO {

    private int id;
    private String name;
    private int age;
    private String email;
    private String department;
}