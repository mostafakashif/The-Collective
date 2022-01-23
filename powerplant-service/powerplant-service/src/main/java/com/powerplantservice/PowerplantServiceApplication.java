package com.powerplantservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.*")
public class PowerplantServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PowerplantServiceApplication.class, args);
    }


}
