package com.kundan.demo.service;

import java.util.List;

import com.kundan.demo.model.Book;

public interface BookService{
	

	public List<Book> findAllBook();
	public Book saveBook(Book book);
	public void deleteBook(Book book);
	
	
}
