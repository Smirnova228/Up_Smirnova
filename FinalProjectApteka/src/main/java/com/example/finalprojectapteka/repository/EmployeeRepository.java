package com.example.finalprojectapteka.repository;

import com.example.finalprojectapteka.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
