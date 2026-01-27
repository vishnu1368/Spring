package com.project.SpringBoot;

import org.springframework.stereotype.Service;

@Service
public class StripePaymentService implements PaymentService{

    @Override
    public void process(double amount) {
        System.out.println("Stripe");
        System.out.println("Amount Processed : " + amount);
    }
}
