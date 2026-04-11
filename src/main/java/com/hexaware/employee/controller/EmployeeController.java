package com.hexaware.employee.controller;

import com.hexaware.employee.dto.Employee;
import com.hexaware.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
//    @Autowired//This is used to inject the service
//    private EmployeeService employeeService;
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    public ResponseEntity<List<Employee>> getEmployee() {
        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<List<Employee>> addEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeByIndex(@PathVariable Integer id) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.updateEmployee(id, employee), HttpStatus.OK);
    }
//
//    @PatchMapping("/{index}")
//    public ResponseEntity<Employee> updateEmployeeByIndex(@PathVariable int index,@RequestParam String name) {
//        return new ResponseEntity<>(employeeService.updateEmployeeName(index, name), HttpStatus.OK);
//    }
//    @DeleteMapping("/{index}")
//    public ResponseEntity<Void> deleteEmployee(@PathVariable int index) {
//        employeeService.deleteEmployee(index);
//        return new ResponseEntity<>( HttpStatus.OK);
//    }


}