package com.example.finalprojectapteka.repository;

import com.example.finalprojectapteka.models.modelUser;
import org.springframework.data.repository.CrudRepository;

public interface userRepository extends CrudRepository<modelUser,Long> {
    modelUser findByUsername(String username);
}
