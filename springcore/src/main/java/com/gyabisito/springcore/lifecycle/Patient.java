package com.gyabisito.springcore.lifecycle;

public class Patient {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        System.out.println("inside setter method");
        this.id = id;
    }
    public void hi(){
        System.out.println("Hi");
    }

    public void bye(){
        System.out.println("Bye");
    }
}
