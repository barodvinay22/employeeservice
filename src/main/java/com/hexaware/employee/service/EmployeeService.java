package com.hexaware.employee.service;

import com.hexaware.employee.dto.Employee;
import com.hexaware.employee.entity.EmployeeEntity;
import com.hexaware.employee.repository.EmployeeJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    //static List<Employee> employeeList = new ArrayList<>();
//    static {
//        employeeList.add(new Employee(1,"John"));
//        employeeList.add(new Employee(2,"Mary"));
//        employeeList.add(new Employee(3,"Bob"));
//        employeeList.add(new Employee(4,"Sue"));
//    }
    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;

    public List<Employee> getEmployees() {
        return employeeJpaRepository.findAll().stream().map(this::toEmployee).toList();// Java 8
    }

    private Employee toEmployee(EmployeeEntity employeeEntity) {
        return new Employee(employeeEntity.getId(), employeeEntity.getName());
    }

    public List<Employee> addEmployee(Employee employee) {
//        employeeList.add(employee);
//        return employeeList;
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName(employee.getName());
        employeeJpaRepository.save(employeeEntity);
        return getEmployees();
    }

    public Employee getEmployeeById(Integer id) {
         return employeeJpaRepository.findById(id).map(this::toEmployee)
                 .orElseThrow(()-> new EntityNotFoundException("Employee with id "+ id+"Not found"));
//        return toEmployee(employeeJpaRepository.getById(id));
    }
//
//    public Employee getEmployeeByIndex(int index) {
//        return employeeList.get(index);
//    }
//
    public Employee updateEmployee(int id, Employee employee) {
//        employeeList.set(index, employee);
//        return employeeList.get(index);
        EmployeeEntity employeeEntiy=employeeJpaRepository.getById(id);
        employeeEntiy.setName(employee.getName());
        employeeJpaRepository.save(employeeEntiy);
        return toEmployee(employeeEntiy);
    }
//
//    public Employee updateEmployeeName(int index, String name) {
//        Employee employee= employeeList.get(index);
//        employee.setName(name);
//        employeeList.add(index, employee);
//        return employeeList.get(index);
//    }
//
//    public void deleteEmployee(int index) {
//        employeeList.remove(index);
//    }
}