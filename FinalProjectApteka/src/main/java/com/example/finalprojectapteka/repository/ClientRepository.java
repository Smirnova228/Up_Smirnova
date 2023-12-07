package com.example.finalprojectapteka.repository;

import com.example.finalprojectapteka.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findByFirstName(String firstNameClient);
}
