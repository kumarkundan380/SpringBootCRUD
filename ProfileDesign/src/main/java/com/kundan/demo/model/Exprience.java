package com.kundan.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="exprience")
public class Exprience {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="designation")
	private String presentDesignation;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="period")
	private String period;

}
