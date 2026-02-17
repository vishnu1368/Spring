package com.project.MessageQueue.controller;

import com.project.MessageQueue.dto.User;
import com.project.MessageQueue.producer.RabbitMQJSONProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class JSONMessageController {

    @Autowired
    private RabbitMQJSONProducer rabbitMQJSONProducer;

    @PostMapping("/publish")
    public void publish(@RequestBody User user){
        rabbitMQJSONProducer.send(user);
    }
}
