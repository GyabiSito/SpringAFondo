package gyabisito.controllers;


import gyabisito.dto.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class ListController {

	@RequestMapping("/readList")
	public ModelAndView sendList() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("displayList");

		Employee employee = new Employee();
		employee.setId(1234);
		employee.setName("John");
		employee.setSalary(8000);

		Employee employee2 = new Employee();
		employee2.setId(2);
		employee2.setName("Jose");
		employee2.setSalary(10000);

		Employee employee3 = new Employee();
		employee3.setId(3);
		employee3.setName("Bob");
		employee3.setSalary(7000);

		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(employee);
		employees.add(employee2);
		employees.add(employee3);

		modelAndView.addObject("employees", employees);

		return modelAndView;
	}
}
