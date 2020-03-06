package com.example.demo.usercv.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "PersonalDetails")
public class PersonalDetails {
	@GeneratedValue
	private int id;

	@Column(name = "firstName",length = 20)
	private String firstName;
	@Column(name = "lastName",length = 20)
	private String lastName;
	@Id
	@Column(name = "email",length = 40)
	private String email;
	@Column(name = "mobileNo",length = 10)
	private String mobileNo;
	@Column(name = "location",length = 20)
	private String location;
	@Column(name = "linkedin",length = 40)
	private String linkedin;
	
	@Transient
	private MultipartFile file;

	@OneToOne(cascade = CascadeType.ALL)
	private Education education;
	
	@OneToOne(cascade = CascadeType.ALL)
	private ProjectDetails projectDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Skills skills;
	
	@OneToOne(cascade = CascadeType.ALL)
	private OthersDetail othersDetail;

	public int getId() {
		return id;
	}
	

	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public Education getEducation() {
		return education;
	}

	public void setEducation(Education education) {
		this.education = education;
	}

	public Skills getSkills() {
		return skills;
	}

	public void setSkills(Skills skills) {
		this.skills = skills;
	}

	public ProjectDetails getProjectDetails() {
		return projectDetails;
	}

	public void setProjectDetails(ProjectDetails projectDetails) {
		this.projectDetails = projectDetails;
	}

	public OthersDetail getOthersDetail() {
		return othersDetail;
	}

	public void setOthersDetail(OthersDetail othersDetail) {
		this.othersDetail = othersDetail;
	}

}
