package com.gyabisito.springcore.constructorinjector;

import com.gyabisito.springcore.constructorinjector.ambiguety.Addition;
import com.gyabisito.springcore.dependencycheck.Prescription;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("com/gyabisito/constructorinjector/addition.xml");
        Addition addition = (Addition) context.getBean("addition");
        System.out.println(addition);

    }
}
