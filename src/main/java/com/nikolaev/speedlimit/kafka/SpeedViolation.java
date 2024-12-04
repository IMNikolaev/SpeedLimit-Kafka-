package com.nikolaev.speedlimit.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpeedViolation {
    private String licensePlate;
    private int speed;
    private LocalDateTime timestamp;
}