package com.ren.microservice_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceServiceApplication.class, args);
    }

}
