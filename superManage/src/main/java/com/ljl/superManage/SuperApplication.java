package com.ljl.superManage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients(basePackages = "com.ljl.superManage.*")
@SpringBootApplication
public class SuperApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuperApplication.class, args);
    }

}
