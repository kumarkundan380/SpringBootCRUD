package com.kundan.demo.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kundan.demo.model.Book;
import com.kundan.demo.serviceimpl.BookServiceImpl;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookServiceImpl bookServiceImpl;
	
	
	@Transactional
	@PostMapping("/saveBook")
	public Book saveBook(@RequestBody Book book) {
		return bookServiceImpl.saveBook(book);
	}
	
	@GetMapping("/getBooks")
	public List<Book> getAllbooks()
	{
		return bookServiceImpl.findAllBook();
	}
	
	@DeleteMapping("/deleteBook")
	public void deleteBook(Book book)
	{
		bookServiceImpl.deleteBook(book);
	}

}
