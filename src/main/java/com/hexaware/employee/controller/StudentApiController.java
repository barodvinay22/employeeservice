package com.hexaware.employee.controller;

import com.hexaware.employee.service.StudentService;
import com.hexaware.student.controller.StudentsApi;
import com.hexaware.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentApiController implements StudentsApi {
    @Autowired
    private StudentService studentService;
//    @Override
//    public ResponseEntity<Student> studentsGet() {
//        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
//    }
    @Override
    public ResponseEntity<Student> studentsPost(Student student) {
        return new ResponseEntity<>(studentService.createStudent(student),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Student> getStudentById(Integer id) {
        return new ResponseEntity<>(studentService.getStudent(id),HttpStatus.CREATED);
    }
}