package com.nikolaev.speedlimit.repositiories;

import com.nikolaev.speedlimit.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}