package com.gyabisito.springcore.lifecycle.interfaces;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    public static void main(String[] args) {
//==========================================INTERFACES LIFECYCLES============================================
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/gyabisito/lifecycle/interfaces.xml");
        com.gyabisito.springcore.lifecycle.interfaces.Patient patient = context.getBean("patient", Patient.class);
        System.out.println(patient);
        context.registerShutdownHook();
    }
}
