package com.example.fortest.bookoa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class BookoaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookoaApplication.class, args);
    }

}
