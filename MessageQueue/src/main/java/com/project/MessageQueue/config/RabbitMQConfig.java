package com.project.MessageQueue.config;


import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.queue.name}")
    private String queue;

    @Value("${rabbitmq.queue.exchange}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    //Spring Bean for rabbitmq queue
    @Bean
    public Queue queue(){
        return new Queue(queue);
    }

    //Spring Bean for rabbitmq exchange
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(exchange);
    }

    //Spring Bean for rabbitmq Binding
    @Bean
    public Binding binding(){
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with(routingKey);
    }

    /*
    Spring Auto-configuration will configure the below beans:
    ConnectionFactory
    RabbitTemplate
    RabbitAdmin
     */
}
