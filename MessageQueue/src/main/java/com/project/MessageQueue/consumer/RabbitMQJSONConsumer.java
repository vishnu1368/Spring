package com.project.MessageQueue.consumer;

import com.project.MessageQueue.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJSONConsumer {
    private static final Logger logger = LoggerFactory.getLogger(RabbitMQJSONConsumer.class);

    /*
    Spring sees:
        Listener method expects User
        Message has contentType=application/json
        Message has __TypeId__ header
     */

    @RabbitListener(queues = "${rabbitmq.jsonqueue.name}")
    public void getMessage(User user){
        logger.info("Consumer received the message, " + user);
    }
}
