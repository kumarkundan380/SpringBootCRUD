package com.kundan.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kundan.demo.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	

}
