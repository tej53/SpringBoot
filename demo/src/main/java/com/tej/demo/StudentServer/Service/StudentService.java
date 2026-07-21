package com.tej.demo.StudentServer.Service;

import com.tej.demo.StudentServer.DTO.CreateStudentRequestDTO;
import com.tej.demo.StudentServer.DTO.CreateStudentResponseDTO;
import com.tej.demo.StudentServer.DTO.UpdateStudentRequestDTO;
import com.tej.demo.StudentServer.DTO.UpdateStudentResponseDTO;
import com.tej.demo.StudentServer.Entity.Student;
import com.tej.demo.StudentServer.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Create Student
    public CreateStudentResponseDTO studentValidate(CreateStudentRequestDTO createStudentRequestDTO) {

        String email = createStudentRequestDTO.getEmail();

        boolean isEmailExists = studentRepository.existsByEmail(email);

        if (isEmailExists) {
            throw new RuntimeException("Email already exists");
        }

        Student student = mapToStudent(createStudentRequestDTO);

        student = studentRepository.save(student);

        return mapToStudentResponseDTO(student);
    }

    // Get Student By Id
    public Student getStudentByid(int id) {

        return studentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Student not found with id: " + id));
    }

    // Get All Students
    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    // Update Student
    public UpdateStudentResponseDTO updateStudent(Integer id,
                                                  UpdateStudentRequestDTO updatedStudent) {

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Student not found with id: " + id));

        existingStudent.setName(updatedStudent.getName());
        existingStudent.setAge(updatedStudent.getAge());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setDepartment(updatedStudent.getDepartment());
        existingStudent.setUpdatedAt(LocalDateTime.now());

        Student savedStudent = studentRepository.save(existingStudent);

        return mapToUpdateStudentResponseDTO(savedStudent);
    }

    // Delete Student
    public String deleteStudentByid(int id) {

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Student not found with id: " + id));

        studentRepository.delete(existingStudent);

        return "Student deleted successfully";
    }

    // ------------------ Mapping Methods ------------------

    private Student mapToStudent(CreateStudentRequestDTO dto) {

        Student student = new Student();

        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());
        student.setDepartment(dto.getDepartment());

        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        return student;
    }

    private CreateStudentResponseDTO mapToStudentResponseDTO(Student student) {

        CreateStudentResponseDTO dto = new CreateStudentResponseDTO();

        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setAge(student.getAge());
        dto.setEmail(student.getEmail());
        dto.setDepartment(student.getDepartment());
        dto.setCreatedAt(student.getCreatedAt());
        dto.setUpdatedAt(student.getUpdatedAt());

        if(dto.getName() == null){
            throw new NullPointerException("Name cannot be empty");
        }

        if(dto.getAge() == 0){
            throw new NullPointerException("Age cannot be empty");
        }

        if(dto.getEmail() == null){
            throw new NullPointerException("Email Cannot be empty");
        }

        if(dto.getDepartment() == null){
            throw new NullPointerException("Department Cannot be empty");
        }



        return dto;
    }

    private UpdateStudentResponseDTO mapToUpdateStudentResponseDTO(Student student) {

        UpdateStudentResponseDTO dto = new UpdateStudentResponseDTO();

        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setAge(student.getAge());
        dto.setEmail(student.getEmail());
        dto.setDepartment(student.getDepartment());

        return dto;
    }
}