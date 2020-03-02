package com.h2sj.springdata.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.h2sj.springdata.jpa.entity"})
@EnableJpaRepositories(basePackages = {"com.h2sj.springdata.jpa.repository"})
public class SpringdataJpaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringdataJpaApplication.class,args);
    }
}
