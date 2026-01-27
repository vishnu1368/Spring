package com.project.SpringBoot;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/*
Three Ways to inject the dependency:
    - Through constructors -> preferred when the dependency is mandate
    - Through Setter method -> preferred when the dependency is not mandate
    - Through Field Injection

IoC - Inversion of Control (Principle)
    Instead of your creating and maintaining the Java Objects
    You focus on writing Business logic and let the spring manages the creation and maintaining the objects
    You can achieve IoC through Dependency Injection

Spring MVC (Model View Controller)

To put any classes into the IoC container, you have to annotate the class with annotation (@Component, @Controller, @Service, @Repository)
And later, we can get the objects from the IoC container.


After you put your classes into the IoC container, you can wire the dependent class through @autowired annotations

@Controller vs @RestController
    Controller excepts a layout() but with RestController we can transfer anything from client to Server.

@RequestMapping - Handles all HTTP methods (GET, POST, PUT, DELETE, etc.)
@GetMapping - Handles only HTTP GET requests implicitly

Lombok Dependency to create getter/setter, constructor
    - This can be done by @Data Annotation


 */

@Service
public class OrderService {

    private PaymentService paymentService;

    //Dependency Injection through Constructor
    //If there are multiple Qualifier for the same attribute then you can prioritise one over other through Qualifier Annotation
    public OrderService(@Qualifier("paypalPaymentService") PaymentService paymentService){
        this.paymentService = paymentService;
    }


    public void makePayment(double amount){
        paymentService.process(amount);
    }

    //Dependency Injection through Setter Method
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}

