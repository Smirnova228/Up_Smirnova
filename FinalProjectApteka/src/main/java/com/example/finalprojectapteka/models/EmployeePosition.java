package com.example.finalprojectapteka.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "employeePosition")
public class EmployeePosition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "Name of Employee Position is required")
    private String nameEmployeePosition;

    @OneToMany(mappedBy = "employeePosition")
    private List<Employee> employees;

    public EmployeePosition(long id, String nameEmployeePosition) {
        this.id = id;
        this.nameEmployeePosition = nameEmployeePosition;
    }

    public EmployeePosition() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameEmployeePosition() {
        return nameEmployeePosition;
    }

    public void setNameEmployeePosition(String nameEmployeePosition) {
        this.nameEmployeePosition = nameEmployeePosition;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
