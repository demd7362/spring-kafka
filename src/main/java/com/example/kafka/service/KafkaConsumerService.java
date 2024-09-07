package com.example.kafka.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumerService {

    @KafkaListener(topics = "error-messages", groupId = "error-handler-group")
    public void consume(String message){
        log.info("consume message [{}]", message);
    }
}
