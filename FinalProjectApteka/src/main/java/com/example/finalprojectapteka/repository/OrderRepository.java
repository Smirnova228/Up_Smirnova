package com.example.finalprojectapteka.repository;

import com.example.finalprojectapteka.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
