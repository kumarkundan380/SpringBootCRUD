package com.kundan.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="book")
public class Book {

	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name="book_id")
	 private int bookId;
	 
	 @Column(name="book_name")
	 private String bookName;
	 
	 @Column(name="auther_name")
	 private String autherName;
	 
	
}
