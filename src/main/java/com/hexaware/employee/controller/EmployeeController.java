package com.hexaware.employee.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    static List<String> employeeList = new ArrayList<>();
    static {
        employeeList.add("John");
        employeeList.add("Mary");
        employeeList.add("Peter");
        employeeList.add("Sara");
    }

    @GetMapping
    public ResponseEntity<List<String>> getEmployee() {
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<List<String>> addEmployee(@RequestBody String name) {
        employeeList.add(name);
        return new ResponseEntity<>(employeeList, HttpStatus.CREATED);
    }
}