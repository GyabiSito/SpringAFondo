package com.gyabisito.springcore.lifecycle.annotations;

import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    public static void main(String[] args) {
        //==========================================ANNOTATIONS===================================================
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/gyabisito/lifecycle/annotations.xml");
        Patient patient = context.getBean("patient",Patient.class);
        System.out.println(patient);
        context.registerShutdownHook();

    }
}
