package com.ren.microservice_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
public class MicroserviceClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceClientApplication.class, args);
    }

}
