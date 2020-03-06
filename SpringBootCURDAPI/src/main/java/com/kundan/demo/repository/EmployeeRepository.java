package com.kundan.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kundan.deom.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
