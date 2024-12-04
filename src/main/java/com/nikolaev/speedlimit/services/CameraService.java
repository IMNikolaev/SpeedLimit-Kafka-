package com.nikolaev.speedlimit.services;

import com.nikolaev.speedlimit.entities.Car;
import com.nikolaev.speedlimit.kafka.SpeedViolation;
import com.nikolaev.speedlimit.kafka.SpeedViolationProducer;
import com.nikolaev.speedlimit.repositiories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CameraService {
    private static final int SPEED_LIMIT = 60;

    private final CarRepository carRepository;
    private final SpeedViolationProducer producer;

    public void detectSpeed(String licensePlate, int speed) {
        Car car = new Car();
        car.setLicensePlate(licensePlate);
        car.setSpeed(speed);

        carRepository.save(car);

        if (speed > SPEED_LIMIT) {
            SpeedViolation violation = new SpeedViolation(
                licensePlate,
                speed,
                LocalDateTime.now()
            );
            producer.sendViolation("speed-violations", violation);
        }
    }
}