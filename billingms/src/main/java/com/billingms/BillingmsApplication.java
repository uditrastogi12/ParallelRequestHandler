package com.billingms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BillingmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(BillingmsApplication.class, args);
        System.out.println("Hello Billing MS");
    }
}
