package com.project.MessageQueue.consumer;

import com.project.MessageQueue.dto.User;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RabbitMQJSONConsumer {
    private static final Logger logger = LoggerFactory.getLogger(RabbitMQJSONConsumer.class);

    /*
    Spring sees:
        Listener method expects User
        Message has contentType=application/json
        Message has __TypeId__ header
     */

    @RabbitListener(queues = "${rabbitmq.jsonqueue.name}", ackMode = "MANUAL")
    public void getMessage(User user, Channel channel,
                           @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag){

        //Every message delivered to a consumer in RabbitMQ has a unique identifier per channel, called the delivery tag.
        logger.info("Consumer received the message, " + user);
        try {
            /*
            CHANNEL:
            Instead of opening a new TCP connection for every producer/consumer:
                You open one connection
                Then create multiple channels inside it
                Each channel can publish or consume independently
                This makes RabbitMQ efficient and scalable.
             */
            channel.basicAck(deliveryTag, false);
            /* What does multiple mean?
                false → Acknowledge only this single message
                true → Acknowledge this message AND all previous unacked messages on this channel
             */
        } catch (Exception e) {
            logger.error("ACK failed, attempting NACK", e);
            try {
                channel.basicNack(deliveryTag, false, false); // requeue = [false, true]
            } catch (IOException ioException) {
                logger.error("NACK failed", ioException);
            }
        }
    }
}
