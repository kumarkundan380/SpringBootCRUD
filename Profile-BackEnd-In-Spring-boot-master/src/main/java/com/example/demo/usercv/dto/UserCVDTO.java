package com.example.demo.usercv.dto;

public class UserCVDTO {

	private String firstName;
	private String lastName;
	private String email;
	private String mobileNo;
	private String location;
	private String linkedin;
	private String education;
	private String programing;
	private String webTech;
	private String dbs;
	private String title;
	private String description;
	private String organisation;
	private String designation;
	private String experience;
	private String about;
	private String achievement;

	public UserCVDTO() {
		super();
	}

	public UserCVDTO(String firstName, String lastName, String email, String mobileNo, String location,
			String linkedin, String education, String programing, String webTech, String dbs, String title,
			String description) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.mobileNo=mobileNo;
		this.location=location;
		this.linkedin=linkedin;
		this.education=education;
		this.programing=programing;
		this.webTech=webTech;
		this.dbs=dbs;
		this.title=title;
		this.description=description;
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

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
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

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getPrograming() {
		return programing;
	}

	public void setPrograming(String programing) {
		this.programing = programing;
	}

	public String getWebTech() {
		return webTech;
	}

	public void setWebTech(String webTech) {
		this.webTech = webTech;
	}

	public String getDbs() {
		return dbs;
	}

	public void setDbs(String dbs) {
		this.dbs = dbs;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOrganisation() {
		return organisation;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getAchievement() {
		return achievement;
	}

	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}
	

}
