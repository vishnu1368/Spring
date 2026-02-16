package com.project.MessageQueue;

public class temp {
    public static void main(String[] args){
        System.out.println("Hello world");
    }
}
/*
    docker run -it -p 15672:15672 -p 5672:5672 rabbitmq:4.2.3-management
    RabbitMQ UI Username : guest
    RabbitMQ UI password : guest
    Create the exchange and create the Queue
    Bind the Queue to the exchange with a binding Key
 */