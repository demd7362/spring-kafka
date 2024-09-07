package com.example.kafka.common;


import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RequiredArgsConstructor
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleException(RuntimeException e) {
        kafkaTemplate.send("error-messages", e.getMessage());
        return ResponseEntity.status(500).body(e.getMessage());
    }
}


