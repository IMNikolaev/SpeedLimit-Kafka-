package com.nikolaev.speedlimit.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SpeedViolationConsumer {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "speed-violations", groupId = "violation-group")
    public void handleViolation(String message) {
        try {
            SpeedViolation violation = objectMapper.readValue(message, SpeedViolation.class);
            log.warn("Received speed violation: License Plate={}, Speed={}, Timestamp={}",
                     violation.getLicensePlate(),
                     violation.getSpeed(),
                     violation.getTimestamp());
        } catch (Exception e) {
            log.error("Failed to process violation message", e);
        }
    }
}