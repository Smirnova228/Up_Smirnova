package com.example.finalprojectapteka.repository;

import com.example.finalprojectapteka.models.Point;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointRepository extends JpaRepository<Point, Long> {
    Point findByNamePoint(String nameStore);

}
