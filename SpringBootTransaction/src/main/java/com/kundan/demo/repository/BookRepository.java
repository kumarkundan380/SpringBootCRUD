package com.kundan.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kundan.demo.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	
}
