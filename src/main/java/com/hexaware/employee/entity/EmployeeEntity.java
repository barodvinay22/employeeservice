package com.hexaware.employee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "employee")
public class EmployeeEntity {
    @Id// Primary Key For Table(Unique And Not null)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;// Integer=null int=0
    @Column(name = "emp_name")
    private String name;
    @Column(name="age")
    private Integer age;

    @OneToOne
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}