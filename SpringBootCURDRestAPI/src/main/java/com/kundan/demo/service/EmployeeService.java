package com.kundan.demo.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.kundan.demo.model.Employee;

public interface EmployeeService{
	

	
	public List<Employee> findAll();
	
	public Optional<Employee> findById(Long empId);
	
	public Employee save(Employee employee);
	
	public Optional<Employee> update(Long empId,Employee employee);
	
	public void delete(Employee employee);
	
	public MultipartFile uploadeImage(MultipartFile file);
	
	public ResponseEntity<Map<String,String>> getImage();
}

