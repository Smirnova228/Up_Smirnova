package com.example.finalprojectapteka.repository;

import com.example.finalprojectapteka.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String nameProduct);


}
