package com.nikolaev.speedlimit.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String licensePlate;

    private int speed;

    private LocalDateTime detectedAt = LocalDateTime.now();
}