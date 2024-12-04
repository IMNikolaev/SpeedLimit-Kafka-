package com.nikolaev.speedlimit.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SpeedViolationProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public void sendViolation(String topic, SpeedViolation violation) {
        try {
            String message = objectMapper.writeValueAsString(violation);
            kafkaTemplate.send(topic, message);
            log.info("Sent speed violation: {}", message);
        } catch (Exception e) {
            log.error("Failed to send speed violation", e);
        }
    }
}