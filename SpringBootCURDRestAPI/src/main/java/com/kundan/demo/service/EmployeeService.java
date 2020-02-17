package com.kundan.demo.service;

import java.util.List;
import java.util.Optional;
import com.kundan.demo.model.Employee;

public interface EmployeeService{
	

	
	public List<Employee> findAll();
	
	public Optional<Employee> findById(Long empId);
	
	public Employee save(Employee employee);
	
	public Optional<Employee> update(Long empId,Employee employee);
	
	public void delete(Employee employee);
	
}

