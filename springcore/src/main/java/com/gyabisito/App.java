package com.gyabisito;

import com.gyabisito.springcore.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//==========================================MAIN=========================================================================
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/gyabisito/config.xml");
//        Employee employee = (Employee) context.getBean("emp");
//        System.out.println("Id: " + employee.getId());
//        System.out.println("Name: " + employee.getName());
//=========================================LIST=========================================================================
//        ApplicationContext context = new ClassPathXmlApplicationContext("com/gyabisito/listconfig.xml");
//        Hospital hospital = (Hospital) context.getBean("hospital");
//        System.out.println("Hospital: " + hospital.getNombre());
//        System.out.println("Departments");
//        hospital.getDepartments().stream().forEach(System.out::println);
//=========================================SET==========================================================================
//        ApplicationContext context = new ClassPathXmlApplicationContext("com/gyabisito/setconfig.xml");
//        CarDealer carDealer = (CarDealer) context.getBean("cardealer", CarDealer.class);
//
//        System.out.println("nombre " + carDealer.getName());
//        System.out.println("Modelos "  + carDealer.getModels());

//=========================================MAP==========================================================================
//        ApplicationContext context = new ClassPathXmlApplicationContext("com/gyabisito/mapconfig.xml");
//        Customer customer = context.getBean("customer", Customer.class);
//        System.out.println("Customer: " + customer);

//=========================================PROPERTIES==========================================================================
//        ApplicationContext context = new ClassPathXmlApplicationContext("com/gyabisito/propertyconfig.xml");
//        CountriesAndLanguages countriesAndLanguages=context.getBean("countriesandlangs", CountriesAndLanguages.class);
//        System.out.println(countriesAndLanguages);
// =========================================REFERENCES==========================================================================
//        ApplicationContext context = new ClassPathXmlApplicationContext("com/gyabisito/referenceconfig.xml");
//        Student student = context.getBean("student",Student.class);
//        System.out.println(student);

// =========================================Shopping Cart==========================================================================
        ApplicationContext context = new ClassPathXmlApplicationContext("com/gyabisito/shoppingcartconfig.xml");
        ShoppingCart shoppingCart = context.getBean("items",ShoppingCart.class);
        System.out.println(shoppingCart);
    }
}
