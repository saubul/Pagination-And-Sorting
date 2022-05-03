package ru.saubulprojects.pagsortapp.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return empRepo.save(employee);
	}
	
	@Override
	public Employee findEmployeeById(Long id) {
		Employee emp = empRepo.findById(id).orElse(null);
		
		if(emp == null) {
			throw new RuntimeException("Employee not found for id: " + id);
		}
		return emp;
	}
	
	@Override
	public void deleteEmployeeById(Long id) {
		empRepo.deleteById(id);
	}

	@Override
	public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		return empRepo.findAll(pageable);
	}
	
	
}
