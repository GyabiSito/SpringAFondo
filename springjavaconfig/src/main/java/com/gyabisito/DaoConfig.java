package com.gyabisito;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
public class DaoConfig {
    @Bean
    public Dao dao() {
        return new Dao();
    }
}
