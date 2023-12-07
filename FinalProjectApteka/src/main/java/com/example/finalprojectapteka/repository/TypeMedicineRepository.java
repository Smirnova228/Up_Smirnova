package com.example.finalprojectapteka.repository;

import com.example.finalprojectapteka.models.TypeMedicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeMedicineRepository extends JpaRepository<TypeMedicine, Long> {
    TypeMedicine findByNameTypeMedicine(String nameTypeProduct);
}
