package com.gyabisito;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class Demo {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("com/gyabisito/config.xml");
        EmployeeDAO con = (EmployeeDAO) context.getBean("employeeDAO");
//        int result=con.create(new Employee(2,"jose","pepe"));
//        System.out.println("Number of rows inserted: "+result);
//        int result2=con.create(new Employee(2,"jose","pepe"));
//        System.out.println("Number of rows inserted: "+result2);
//        int result3=con.update(new Employee(2,"jose","SAPO"));


        Employee res4=con.read(2);
        System.out.println(res4);

        List<Employee> employees=con.readAll();
        System.out.println(employees);
    }

}
