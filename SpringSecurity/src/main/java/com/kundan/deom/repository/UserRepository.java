package com.kundan.deom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kundan.deom.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
