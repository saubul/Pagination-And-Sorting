package ru.saubulprojects.pagsortapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.saubulprojects.pagsortapp.model.Employee;
import ru.saubulprojects.pagsortapp.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private final EmployeeService empService;
	
	public EmployeeController(EmployeeService empService) {
		this.empService = empService;
	}
	
	@GetMapping
	public String indexForm(Model model) {
		
		model.addAttribute("employees", empService.getAllEmployees());
		return "index";
		
	}
	
	@GetMapping("/new")
	public String newEmpForm(Model model) {
		model.addAttribute("emp", new Employee());
		return "newEmp";
	}
	
	@PostMapping("/new")
	public String saveEmp(@ModelAttribute("emp") Employee employee) {
		
		empService.saveEmployee(employee);
		return "index";
	}
	
}

