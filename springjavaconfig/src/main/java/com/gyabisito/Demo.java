package com.gyabisito;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//        Dao dao=context.getBean(Dao.class);
//        dao.create();
        Service service = context.getBean(Service.class);
        service.save();
        context.close();
    }
}
