package com.kundan.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDTO {
	
	private String firstName;
	private String lastName;
	private String email;
	private String mobileNo;
	private String address;
	private String skill;
	private String hobbies;
	private String languages;
	private String imageName;
	private String designation;
	private String sscBoard;
	private String sscPercentage;
	private String sscYear;
	private String hscBoard;
	private String hscPercentage;
	private String hscYear;
	private String bscBoard;
	private String bscPercentage;
	private String bscYear;
	private String pgBoard;
	private String pgPercentage;
	private String pgYear;
	private String presentDesignation;
	private String companyName;
	private String period;

}
