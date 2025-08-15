package com.gyabisito.springcore.innerbeans;

import com.gyabisito.springcore.dependencycheck.Prescription;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/gyabisito/innerbeans/config.xml");
        Employee employee = (Employee) context.getBean("employee");
        System.out.println(employee);
    }
}
