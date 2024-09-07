package com.example.kafka.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.template.default-topic}")
    private String defaultTopic;

    public void sendMessageToKafka(String message) {
        log.info("produce message [{}]", message);
        kafkaTemplate.send(defaultTopic, message);
    }
}
