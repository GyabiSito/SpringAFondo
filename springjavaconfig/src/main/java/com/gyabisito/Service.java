package com.gyabisito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    Dao dao;

    @Bean
    public void save(){
        dao.create();
    }

    public void init(){
        System.out.println("Inicializando el DAO");
    }
    public void destroy(){
        System.out.println("Destruidando el DAO");
    }
}
