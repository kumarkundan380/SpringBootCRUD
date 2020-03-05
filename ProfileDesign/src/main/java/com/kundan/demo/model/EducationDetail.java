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
@Table(name = "education_detail")
public class EducationDetail {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "ssc_board")
	private String sscBoard;
	
	@Column(name = "ssc_percentage")
	private String sscPercentage;
	
	@Column(name = "ssc_year")
	private String sscYear;
	
	@Column(name = "hsc_board")
	private String hscBoard;
	
	@Column(name = "hsc_percentage")
	private String hscPercentage;
	
	@Column(name = "hsc_year")
	private String hscYear;
	
	@Column(name = "bsc_board")
	private String bscBoard;
	
	@Column(name = "bsc_percentage")
	private String bscPercentage;
	
	@Column(name = "bsc_year")
	private String bscYear;
	
	@Column(name = "pg_board")
	private String pgBoard;
	
	@Column(name = "pg_percentage")
	private String pgPercentage;
	
	@Column(name = "pg_year")
	private String pgYear;

	

}
