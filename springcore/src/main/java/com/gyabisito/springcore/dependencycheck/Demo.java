package com.gyabisito.springcore.dependencycheck;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/gyabisito/dependencycheck/config.xml");
        Prescription prescription = context.getBean("prescription",Prescription.class);
        System.out.println(prescription);

    }
}
