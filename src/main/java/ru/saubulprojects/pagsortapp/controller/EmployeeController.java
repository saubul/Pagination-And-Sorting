package ru.saubulprojects.pagsortapp.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		
		return findPaginated(1, model);
	}
	
	@GetMapping("/new")
	public String newEmpForm(Model model) {
		model.addAttribute("emp", new Employee());
		return "newEmp";
	}
	
	@PostMapping("/new")
	public String saveEmp(@ModelAttribute("emp") Employee employee) {
		
		empService.saveEmployee(employee);
		return "redirect:/employees";
	}
	
	@GetMapping("/{id}/update")
	public String getUpdateEmployeeForm(@PathVariable("id") Long id, Model model) {
		
		model.addAttribute("emp", empService.findEmployeeById(id));
		return "update";
		
	}
	
	@PostMapping("/{id}/update")
	public String updateEmployee(@ModelAttribute("emp") Employee emp) {
		
		empService.saveEmployee(emp);
		return "redirect:/employees";
		
	}
	
	@GetMapping("/{id}/delete")
	public String deleteEmployee(@PathVariable("id") Long id) {
		
		empService.deleteEmployeeById(id);
		return "redirect:/employees";
		
	}
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable("pageNo") int pageNo, Model model) {
		int pageSize = 5;
		
		Page<Employee> page = empService.findPaginated(pageNo, pageSize);
		List<Employee> listEmployees = page.getContent();
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("listEmployees", listEmployees);
		
		return "index";
	}
}

