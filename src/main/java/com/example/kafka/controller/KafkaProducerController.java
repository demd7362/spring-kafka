package com.example.kafka.controller;

import com.example.kafka.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/kafka")
public class KafkaProducerController {
    private final KafkaProducerService kafkaProducerService;

    @PostMapping
    public ResponseEntity<Void> sendMessage(@RequestParam String message) {
        kafkaProducerService.sendMessageToKafka(message);
        return ResponseEntity.ok().build();
    }
}
