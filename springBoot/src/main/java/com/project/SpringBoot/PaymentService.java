package com.project.SpringBoot;

import org.springframework.stereotype.Service;


public interface PaymentService {
    void process(double amount);
}
