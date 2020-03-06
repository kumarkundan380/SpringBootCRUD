package com.kundan.demo.serviceimpl;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kundan.demo.model.Book;
import com.kundan.demo.repository.BookRepository;
import com.kundan.demo.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookRepository bookRepository;

	@Override
	public List<Book> findAllBook() {
		return bookRepository.findAll();
	}
	
//	@Transactional
//	@Override
//	public Book saveBook(Book book) {
//		return bookRepository.save(book);
//	}
	
	@Transactional
	@Override
	public Book saveBook(Book book) {
		Book book1 = bookRepository.save(book);
		int a = 10/0;
		System.out.println(a);
		return book1;
	}
	@Transactional
	@Override
	public void deleteBook(Book book) {
		bookRepository.delete(book);
		
	}

	
}
