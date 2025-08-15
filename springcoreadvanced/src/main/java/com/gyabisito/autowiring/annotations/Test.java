package com.gyabisito.autowiring.annotations;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/gyabisito/autowiring/annotations/config.xml");
		Employee e = (Employee) context.getBean("employee");
		System.out.println(e);

	}

}
