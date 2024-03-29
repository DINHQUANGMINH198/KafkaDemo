package com.example.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class MessageController {

    @Value("${spring.kafka.topic.message-topic}")
    private String messageTopic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/{message}")
    public String send(@PathVariable("message") String message) {
        kafkaTemplate.send(messageTopic, message);
        return "Producer sends msg: " + message;
    }
}
