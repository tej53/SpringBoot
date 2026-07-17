package com.tej.demo.StudentServer.Controller;

import com.tej.demo.StudentServer.Entity.Student;
import com.tej.demo.StudentServer.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> storeStudent(@RequestBody Student student){
        Student result = studentService.validateStudent(student);

        if(result == null){
            ResponseEntity.status(400).body(result);
        }

        return ResponseEntity.status(201).body(result);
    }

    @GetMapping("/get-students/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable int id){
        Student student = studentService.getStudentById(id);
        return ResponseEntity.status(200).body(student);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudentById(@PathVariable int id, @RequestBody Student student){
        Student updateStudent = studentService.updateStudentById(id, student);
        if(updateStudent == null){
            return ResponseEntity.status(400).body("Student not found");
        }

        return ResponseEntity.ok(updateStudent);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id){
        return studentService.deleteStudentById(id);
    }


}
