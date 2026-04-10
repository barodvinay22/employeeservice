package com.hexaware.employee.service;

import com.hexaware.employee.dto.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    static List<Employee> employeeList = new ArrayList<>();
    static {
        employeeList.add(new Employee(1,"John"));
        employeeList.add(new Employee(2,"Mary"));
        employeeList.add(new Employee(3,"Bob"));
        employeeList.add(new Employee(4,"Sue"));
    }

    public List<Employee> getEmployees() {
        return employeeList;
    }

    public List<Employee> addEmployee(Employee employee) {
        employeeList.add(employee);
        return employeeList;
    }

    public Employee getEmployeeByIndex(int index) {
        return employeeList.get(index);
    }

    public Employee updateEmployee(int index, Employee employee) {
        employeeList.set(index, employee);
        return employeeList.get(index);
    }

    public Employee updateEmployeeName(int index, String name) {
        Employee employee= employeeList.get(index);
        employee.setName(name);
        employeeList.add(index, employee);
        return employeeList.get(index);
    }

    public void deleteEmployee(int index) {
        employeeList.remove(index);
    }
}