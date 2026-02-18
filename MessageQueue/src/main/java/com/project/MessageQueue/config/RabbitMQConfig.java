package com.project.MessageQueue.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
Jackson (Java JSON Library)
    Jackson is a popular high-performance Java library used to convert between Java objects and JSON.
    It is widely used in REST APIs, microservices, and frameworks like Spring Boot.
 */

@Configuration
public class RabbitMQConfig {


    @Value("${rabbitmq.queue.exchange}")
    private String exchange;


    @Value("${rabbitmq.queue.name}")
    private String queue;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    @Value("${rabbitmq.jsonqueue.name}")
    private String json_queue;

    @Value("${rabbitmq.jsonrouting.key}")
    private String json_routingKey;


    @Value("${rabbitmq.queue.dlxexchange}")
    private String dlx_exchange;


    @Value("${rabbitmq.dlxqueue.name}")
    private String dlx_queue;

    @Value("${rabbitmq.dlxrouting.key}")
    private String dlx_routingKey;





    //Spring Bean for rabbitmq queue
    @Bean
    public Queue queue(){
        return new Queue(queue);
    }

    @Bean
    public Queue dlxQueue(){
        return new Queue(dlx_queue);
    }

    @Bean
    public Queue jsonqueue(){
        return QueueBuilder.durable(json_queue)
                .deadLetterExchange(dlx_exchange)
                .deadLetterRoutingKey(dlx_routingKey)
                .build();
    }



    //Spring Bean for rabbitmq exchange
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(exchange);
    }
    @Bean
    public TopicExchange DLX_exchange(){
        return new TopicExchange(dlx_exchange);
    }





    //Spring Bean for rabbitmq Binding
    @Bean
    public Binding binding(){
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with(routingKey);
    }

    @Bean
    public Binding jsonbinding(){
        return BindingBuilder
                .bind(jsonqueue())
                .to(exchange())
                .with(json_routingKey);
    }

    @Bean
    public Binding dlxBinding(){
        return BindingBuilder
                .bind(dlxQueue())
                .to(DLX_exchange())
                .with(dlx_routingKey);
    }


    @Bean
    public MessageConverter convert(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate getTemplate(ConnectionFactory connection){
        RabbitTemplate template = new RabbitTemplate(connection);
        template.setMessageConverter(convert());
        return template;
    }

    /*
    Spring Auto-configuration will configure the below beans:
    ConnectionFactory
    RabbitTemplate
    RabbitAdmin
     */
}
