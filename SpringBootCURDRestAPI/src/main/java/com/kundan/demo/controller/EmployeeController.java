package com.kundan.demo.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kundan.demo.exception.ResourceNotFoundException;
import com.kundan.demo.model.Employee;
import com.kundan.demo.service.EmployeeService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	/* To save an employee*/
	@PostMapping("/save")
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		System.out.println("first");
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
	
	@PostMapping("/fileUpload")
	public MultipartFile uploadeImage(@RequestParam("myFile") MultipartFile file) throws Exception {
		
		System.out.println("second");
		return employeeService.uploadeImage(file);
	}
	
	@GetMapping("/getImage")
	public ResponseEntity<Map<String, String>> getImage(){
		return employeeService.getImage();
	}
	
	/* Delete an employee by id*/
	@DeleteMapping("/delete/{id}")
	public void deleteEmployeeById(@PathVariable(value = "id")Long empId) throws ResourceNotFoundException {
		employeeService.delete(employeeService.findById(empId).orElseThrow(() -> new ResourceNotFoundException("User not found :: " + empId)));		
	}
	
}
