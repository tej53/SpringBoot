package com.tej.demo.StudentServer.Controller;
import com.tej.demo.StudentServer.DTO.CreateStudentRequestDTO;
import com.tej.demo.StudentServer.DTO.CreateStudentResponseDTO;
import com.tej.demo.StudentServer.DTO.UpdateStudentRequestDTO;
import com.tej.demo.StudentServer.DTO.UpdateStudentResponseDTO;
import com.tej.demo.StudentServer.Entity.Student;
import com.tej.demo.StudentServer.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    StudentService studentService;


    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    // 1. Store the Student
    @PostMapping("/create")
    public ResponseEntity<CreateStudentResponseDTO> storeStudent(@RequestBody CreateStudentRequestDTO createStudentRequestDTO){
        CreateStudentResponseDTO result = studentService.studentValidate(createStudentRequestDTO);

        if(result == null)
        {
            return ResponseEntity.status(400).body(result);
        }
        return ResponseEntity.status(201).body(result);
    }

    // 2. read the Student with id
    @GetMapping("/getStudent/{id}")
    public ResponseEntity<Student> getStudentByID(@PathVariable int id) {
        Student student = studentService.getStudentByid(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllStudents(){
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.status(200).body(students);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(
            @PathVariable Integer id,
            @RequestBody UpdateStudentRequestDTO updateStudentRequestDTO){

        UpdateStudentResponseDTO updatedStudent = studentService.updateStudent(id, updateStudentRequestDTO);

        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable int id){
        String msg = studentService.deleteStudentByid(id);
        return ResponseEntity.status(200).body(msg);
    }
    // 3. update the student information

    // 4. delete the student information
}