package com.example.finalprojectapteka.repository;

import com.example.finalprojectapteka.models.EmployeePosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePositionRepository extends JpaRepository<EmployeePosition, Long> {
    EmployeePosition findByNameEmployeePosition(String nameEmployeePosition);
}

