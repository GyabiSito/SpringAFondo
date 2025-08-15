package com.gyabisito.springcore.lifecycle.annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Patient {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        System.out.println("inside setter method");
        this.id = id;
    }
    @PostConstruct
    public void hi(){
        System.out.println("Hi");
    }
    @PreDestroy
    public void bye(){
        System.out.println("Bye");
    }
}
