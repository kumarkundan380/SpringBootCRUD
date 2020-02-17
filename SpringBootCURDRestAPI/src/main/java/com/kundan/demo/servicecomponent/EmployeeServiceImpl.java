package com.kundan.demo.servicecomponent;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kundan.demo.model.Employee;
import com.kundan.demo.repository.EmployeeRepository;
import com.kundan.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> findById(Long empId) {
		return employeeRepository.findById(empId);
	}

	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Optional<Employee> update(Long empId,Employee employee) {
		   Employee emp=employeeRepository.findById(empId).get();
		   emp.setFirstName(employee.getFirstName());
		   emp.setLastName(employee.getLastName());
		   emp.setEmail(employee.getEmail());
		   return  Optional.of(emp);
	}

	@Override
	public void delete(Employee employee) {
		employeeRepository.delete(employee);
		
	}
	

}
