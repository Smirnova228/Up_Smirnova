package com.example.finalprojectapteka.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "First Name is required")
    private String firstNameEmployee;
    @NotBlank(message = "Second Name is required")
    private String secondNameEmployee;
    @NotBlank(message = "Middle Name is required")
    private String middleNameEmployee;
    @NotBlank(message = "Email is required")
    private String emailEmployee;
    @NotBlank(message = "Password is required")
    private String passwordEmployee;


    @ManyToOne
    private EmployeePosition employeePosition;

    public Employee(int id, String firstNameEmployee, String secondNameEmployee, String middleNameEmployee, String emailEmployee, String passwordEmployee, EmployeePosition employeePosition) {
        this.id = id;
        this.firstNameEmployee = firstNameEmployee;
        this.secondNameEmployee = secondNameEmployee;
        this.middleNameEmployee = middleNameEmployee;
        this.emailEmployee = emailEmployee;
        this.passwordEmployee = passwordEmployee;
        this.employeePosition = employeePosition;
    }

    public Employee() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstNameEmployee() {
        return firstNameEmployee;
    }

    public void setFirstNameEmployee(String firstNameEmployee) {
        this.firstNameEmployee = firstNameEmployee;
    }

    public String getSecondNameEmployee() {
        return secondNameEmployee;
    }

    public void setSecondNameEmployee(String secondNameEmployee) {
        this.secondNameEmployee = secondNameEmployee;
    }

    public String getMiddleNameEmployee() {
        return middleNameEmployee;
    }

    public void setMiddleNameEmployee(String middleNameEmployee) {
        this.middleNameEmployee = middleNameEmployee;
    }

    public String getEmailEmployee() {
        return emailEmployee;
    }

    public void setEmailEmployee(String emailEmployee) {
        this.emailEmployee = emailEmployee;
    }

    public String getPasswordEmployee() {
        return passwordEmployee;
    }

    public void setPasswordEmployee(String passwordEmployee) {
        this.passwordEmployee = passwordEmployee;
    }

    public EmployeePosition getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(EmployeePosition employeePosition) {
        this.employeePosition = employeePosition;
    }
}

