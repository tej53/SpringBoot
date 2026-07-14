package com.tej.demo.StudentServer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentServer {
    //1. Store the Student
    @PostMapping("/create")
    public String storeStudent(){
        return """
            id : 1
            name : Tej
            Department : CSE
            age : 25
            """;
    }

    //2. Read the Student with id

    //3. Update the Student information

    //4. Delete the Student information
}
