package com.nikolaev.speedlimit.controllers;


import com.nikolaev.speedlimit.services.CameraService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/camera")
@RequiredArgsConstructor
public class CameraController {
    private final CameraService cameraService;

    @PostMapping("/detect")
    public void detectSpeed(@RequestParam String licensePlate, @RequestParam int speed) {
        cameraService.detectSpeed(licensePlate, speed);
    }
}