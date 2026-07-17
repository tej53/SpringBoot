package com.tej.demo.StudentServer.Service;

import com.tej.demo.StudentServer.Entity.Student;
import com.tej.demo.StudentServer.Repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student validateStudent(Student student){
        int id = student.getId();
        String name = student.getName();
        int age = student.getAge();
        String department = student.getDepartment();

        if(id<0 || name == null || age < 0 || department == null){
            return null;
        }

        studentRepository.save(student);
        return student;
    }

    public Student getStudentById(int id){
        Student student = studentRepository.findById(id).orElse(null);
        return student;
    }

    public Student updateStudentById(Integer id, Student updatedStudent){
        Student existingStudent = studentRepository.findById(id).orElse(null);

        if(existingStudent == null){
            return null;
        }

        existingStudent.setName(updatedStudent.getName());
        existingStudent.setAge(updatedStudent.getAge());
        existingStudent.setDepartment(updatedStudent.getDepartment());

        return studentRepository.save(existingStudent);
    }


    public String deleteStudentById(Integer id){
        studentRepository.deleteById(id);
        return "Student Deleted successfully";
    }
}
