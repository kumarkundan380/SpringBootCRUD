package com.kundan.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="profile")
public class Profile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="mobile_no")
	private String mobileNo;

//	@Column(name="dob")
//	private String dob;
	
	@Column(name="skill")
	private String skill;

	@Column(name="hobbies")
	private String hobbies;

//	@Column(name="gender")
//	private String gender;
	
	@Column(name="address")
	private String address;
	
	@Column(name="languages")
	private String languages;
	
	@Column(name="image_name")
	private String imageName;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	public EducationDetail education;
	
	@OneToOne(cascade=CascadeType.ALL)
	public Exprience exprience;
	
}
