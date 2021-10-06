package com.customermanager.enterprise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackages={
        "com.customermanager.enterprise.dto", "com.customermanager.enterprise.dao"
        , "com.customermanager.enterprise.controller", "com.customermanager.enterprise.service"})
public class CustomerManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerManagerApplication.class, args);
    }

}
