package com.example.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("msg")
public class MessageController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("")
    public String send() {
        kafkaTemplate.send("test", "Hello");
        return "OK";
    }
}
