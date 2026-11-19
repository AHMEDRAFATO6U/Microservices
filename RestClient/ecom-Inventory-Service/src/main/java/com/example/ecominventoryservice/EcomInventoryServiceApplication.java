package com.example.ecominventoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcomInventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcomInventoryServiceApplication.class, args);
        System.out.println("INVENTORY SERVICE RUN SUCCESSFULLY ON PORT : 8081");
    }

}
