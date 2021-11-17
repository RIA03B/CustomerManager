package com.customermanager.enterprise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableJpaRepositories
@EnableCaching
public class CustomerManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerManagerApplication.class, args);
    }

}