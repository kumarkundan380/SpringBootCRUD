package com.kundan.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kundan.demo.repository.EmployeeRepository;
import com.kundan.demo.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	/* Get all employee */
	public List<Employee> getAllEmployee(){
		return employeeRepository.findAll();
	}
	
	/*Get an employee by id */
	public Optional<Employee> getEmployeeById(Long empId) {
		return employeeRepository.findById(empId);
		
	}
	
	/*Save an employee */
	@Transactional
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	/*Delete an employee */
	public Map<String,Boolean> deleteEmployee(Employee employee){
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;

	}
	
}

