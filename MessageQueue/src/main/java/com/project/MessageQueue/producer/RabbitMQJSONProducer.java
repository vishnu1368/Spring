package com.project.MessageQueue.producer;

import com.project.MessageQueue.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class RabbitMQJSONProducer {

    @Value("${rabbitmq.queue.exchange}")
    private String exchange;

    @Value("${rabbitmq.jsonrouting.key}")
    private String json_routingKey;

    @Autowired
    private RabbitTemplate rabbitTemplate;
    private static final Logger logger = LoggerFactory.getLogger(RabbitMQJSONProducer.class);

    public void send(User user){
        logger.info("Got the JSON string -> " + user);
        rabbitTemplate.convertAndSend(exchange, json_routingKey, user);
    }
}
