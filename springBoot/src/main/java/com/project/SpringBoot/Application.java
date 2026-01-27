package com.project.SpringBoot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(Application.class, args);
		var orderService = context.getBean(OrderService.class);
		orderService.makePayment(25);

		/*
		Example to demonstrate DI through Constructor and Setter methods
		OrderService orderService = new OrderService(new StripePaymentService());
		orderService.makePayment(25);
		 */

	}
}
