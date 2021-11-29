package com.example.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "${spring.kafka.topic.message-topic}", groupId = "${spring.kafka.group-id}")
    public void consumer(String message) {
        System.out.println("Consumer receives msg: " + message);
    }
}
