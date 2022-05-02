package ru.saubulprojects.pagsortapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import ru.saubulprojects.pagsortapp.model.Employee;
import ru.saubulprojects.pagsortapp.repository.EmployeeRepository;
import ru.saubulprojects.pagsortapp.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private final EmployeeRepository empRepo;
	
	public EmployeeServiceImpl(EmployeeRepository empRepo) {
		this.empRepo = empRepo;
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}
	
}
