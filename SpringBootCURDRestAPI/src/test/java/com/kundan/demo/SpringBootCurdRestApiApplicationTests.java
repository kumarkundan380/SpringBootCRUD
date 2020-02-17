package com.kundan.demo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.stream.Collectors;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.kundan.demo.model.Employee;
import com.kundan.demo.repository.EmployeeRepository;
import com.kundan.demo.servicecomponent.EmployeeServiceImpl;

@SpringBootTest
class SpringBootCurdRestApiApplicationTests {
	
	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	
	@MockBean
	private EmployeeRepository employeeRepository;

	@Test
	public void findAllTest()
	{
		Employee employee=new Employee();
		employee.setFirstName("Kundan");
		employee.setLastName("Kumar");
		employee.setEmail("kumarkundan380@gmail.com");
		when(employeeRepository.findAll()).thenReturn(Stream.of(employee).collect(Collectors.toList()));
		assertEquals(1, employeeServiceImpl.findAll().size());
	}
	
	@Test
	public void saveTest()
	{
		Employee employee=new Employee();
		employee.setFirstName("Kundan");
		employee.setLastName("Kumar");
		employee.setEmail("kumarkundan380@gmail.com");	
		when(employeeRepository.save(employee)).thenReturn(employee);
		Employee emp=employeeServiceImpl.save(employee);
		assertEquals(employee,emp);
	}
	
	@Test
	public void findByIdTest()
	{
		Long id=2L;
		Employee employee=new Employee();
		employee.setFirstName("Kundan");
		employee.setLastName("Kumar");
		employee.setEmail("kumarkundan380@gmail.com");
		employeeServiceImpl.findById(id);
		verify(employeeRepository,times(1)).findById(id);
	}
//	@Test
//	public void updateTest()
//	{
//		Long id=1L;
//		Employee employee=new Employee();
//		employee.setFirstName("Kundan");
//		employee.setLastName("Kumar");
//		employee.setEmail("kumarkundan380@gmail.com");
//		
//		employeeServiceImpl.update(id,employee);
//		verify(employeeRepository,times(1)).update(id,employee);
//	}
	
	@Test
	public void deleteTest()
	{
		Employee employee=new Employee();
		employee.setFirstName("Kundan");
		employee.setLastName("Kumar");
		employee.setEmail("kumarkundan380@gmail.com");
		employeeServiceImpl.delete(employee);
		verify(employeeRepository,times(1)).delete(employee);
	}
	
}
