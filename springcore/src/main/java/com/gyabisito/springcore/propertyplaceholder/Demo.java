package com.gyabisito.springcore.propertyplaceholder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("com/gyabisito/propertyplaceholder/config.xml");
        MyDAO myDao=context.getBean("mydao",MyDAO.class);
        System.out.println(myDao);
    }
}
