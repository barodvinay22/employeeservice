package com.hexaware.employee.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile(value = "dev")
@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    @GetMapping
    public String getDepartment() {
        return "Department";
    }
}