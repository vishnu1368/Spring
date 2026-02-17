package com.project.MessageQueue.controller;

import com.project.MessageQueue.producer.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/api/v1")
public class MessageController {
    @Autowired
    private RabbitMQProducer producer;

    @GetMapping("/publish")
    public ResponseEntity publishMessage(@RequestParam("message") String message){
        producer.send(message);
        return ResponseEntity.ok("Message sent to RabbitMQ!");
    }

}
