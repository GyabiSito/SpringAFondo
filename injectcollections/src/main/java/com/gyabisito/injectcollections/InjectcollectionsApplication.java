package com.gyabisito.injectcollections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class InjectcollectionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(InjectcollectionsApplication.class, args);
    }

    @Bean
    public List<String> courseList(){
        return Arrays.asList("Java","Spring","Hibernate","Spring Boot in Action");
    }
}
