package com.oym.mappercenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 14396
 */
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients(basePackages = "com.oym.mappercenter.controller")
public class MapperCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(MapperCenterApplication.class, args);
    }

}
