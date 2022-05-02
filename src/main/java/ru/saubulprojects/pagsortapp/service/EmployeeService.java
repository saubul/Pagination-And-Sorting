package ru.saubulprojects.pagsortapp.service;

import java.util.List;

import ru.saubulprojects.pagsortapp.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();
	
	Employee saveEmployee(Employee employee);
	
}
