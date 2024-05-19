package com.project.productservicedecmwfeve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class ProductservicedecmwfeveApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductservicedecmwfeveApplication.class, args);
    }

}
