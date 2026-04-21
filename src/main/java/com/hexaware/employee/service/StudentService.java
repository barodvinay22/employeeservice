package com.hexaware.employee.service;

import com.hexaware.employee.entity.StudentEntity;
import com.hexaware.employee.repository.StudentRepository;
import com.hexaware.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

//    public Student getStudents() {
//        return (Student) studentRepository.findAll().stream().map(this::toStudent).toList();
//    }

    private Student toStudent(StudentEntity studentEntity) {
        Student student = new Student();
        student.setId(studentEntity.getId());
        student.setName(studentEntity.getName());
        student.setAge(studentEntity.getAge());
        return student;
    }

    public Student createStudent(Student student) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(student.getName());
        studentEntity.setAge(student.getAge());
        return toStudent(studentRepository.save(studentEntity));
    }

    public Student getStudent(Integer id) {
        StudentEntity studentEntity = studentRepository.getOne(id);
        return toStudent(studentEntity);
    }
}