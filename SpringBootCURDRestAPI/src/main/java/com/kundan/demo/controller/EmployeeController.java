package com.kundan.demo.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kundan.demo.exception.ResourceNotFoundException;
import com.kundan.demo.model.Employee;
import com.kundan.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	/* To save an employee*/
	@PostMapping("/save")
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		return employeeService.save(emp);
	}
	
	/* Get all employee */
	@GetMapping("/getAll")
	public List<Employee> getAllEmployees(){
		return employeeService.findAll();
	}

	/* Get an employee by id*/
	@GetMapping("/fetch/{id}")
	public Employee getEmployeeByIds(@PathVariable(value = "id")Long empId)throws ResourceNotFoundException {
		return employeeService.findById(empId).orElseThrow(() -> new ResourceNotFoundException("User not found :: " + empId));
	}
	
	/* Update an employee by id*/
	@PutMapping("/update/{id}")
	public Employee updateEmployee(@PathVariable(value = "id") Long empId, @Valid @RequestBody Employee employee) throws ResourceNotFoundException{
		return employeeService.update(empId,employee).orElseThrow(() -> new ResourceNotFoundException("User not found :: " + empId));
		
		
	}
	
	/* Delete an employee by id*/
	@DeleteMapping("/delete/{id}")
	public void deleteEmployeeById(@PathVariable(value = "id")Long empId) throws ResourceNotFoundException {
	//	Employee employee=employeeService.findById(empId).orElseThrow(() -> new ResourceNotFoundException("User not found :: " + empId));
		employeeService.delete(employeeService.findById(empId).orElseThrow(() -> new ResourceNotFoundException("User not found :: " + empId)));		
	}
	
}
