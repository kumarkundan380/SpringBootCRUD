package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.usercv.bean.Education;
import com.example.demo.usercv.bean.OthersDetail;
import com.example.demo.usercv.bean.PersonalDetails;
import com.example.demo.usercv.bean.ProjectDetails;
import com.example.demo.usercv.bean.Skills;
import com.example.demo.usercv.dto.UserCVDTO;
import com.example.demo.usercv.repo.UserCVRepo;
import com.example.demo.usercv.service.UserCVServiceImpl;

@SpringBootTest
class UserCvApplicationTests {
	@Autowired
	UserCVServiceImpl userCVServiceImpl;

	@MockBean
	UserCVRepo userCVRepo;

	@Test
	public void addTest() {
		UserCVDTO userCVDTO = new UserCVDTO("Bhushan", "Singh", "9835819055", "bks@gmail.com", "ranchi",
				"http://bhushan", "MCA", "c,java", "angular", "mysql", "working", "won");

		ProjectDetails project = new ProjectDetails();

		project.setTitle(userCVDTO.getTitle());
		project.setDescription(userCVDTO.getDescription());

		Skills skill = new Skills();

		skill.setPrograming(userCVDTO.getPrograming());
		skill.setWebTech(userCVDTO.getWebTech());
		skill.setDbs(userCVDTO.getDbs());
		

		Education education = new Education();
		education.setEducation(userCVDTO.getEducation());
		

		PersonalDetails personalDeatils = new PersonalDetails();

		personalDeatils.setFirstName(userCVDTO.getFirstName());
		personalDeatils.setLastName(userCVDTO.getLastName());
		personalDeatils.setEmail(userCVDTO.getEmail());
		personalDeatils.setMobileNo(userCVDTO.getMobileNo());
		personalDeatils.setLocation(userCVDTO.getLocation());
		personalDeatils.setLinkedin(userCVDTO.getLinkedin());

		personalDeatils.setEducation(education);
		personalDeatils.setSkills(skill);
		personalDeatils.setProjectDetails(project);

		when(userCVRepo.save(personalDeatils)).thenReturn(personalDeatils);

		
		PersonalDetails personalDetails1 = userCVServiceImpl.add1(personalDeatils);
	
		assertEquals(personalDeatils, personalDetails1);
	}

	@Test
	public void findTest() {
		UserCVDTO userCVDTO = new UserCVDTO("Bhushan", "Singh", "9835819055", "bks@gmail.com", "ranchi",
				"http://bhushan", "MCA", "c,java", "angular", "mysql", "working", "won");
		ProjectDetails project = new ProjectDetails();

		project.setTitle(userCVDTO.getTitle());
		project.setDescription(userCVDTO.getDescription());

		Skills skill = new Skills();

		skill.setPrograming(userCVDTO.getPrograming());
		skill.setWebTech(userCVDTO.getWebTech());
		skill.setDbs(userCVDTO.getDbs());
		

		Education education = new Education();
		education.setEducation(userCVDTO.getEducation());
		OthersDetail othersDetail=new OthersDetail();
		

		PersonalDetails personalDeatils = new PersonalDetails();

		personalDeatils.setFirstName(userCVDTO.getFirstName());
		personalDeatils.setLastName(userCVDTO.getLastName());
		personalDeatils.setEmail(userCVDTO.getEmail());
		personalDeatils.setMobileNo(userCVDTO.getMobileNo());
		personalDeatils.setLocation(userCVDTO.getLocation());
		personalDeatils.setLinkedin(userCVDTO.getLinkedin());

		personalDeatils.setEducation(education);
		
		personalDeatils.setSkills(skill);
		personalDeatils.setProjectDetails(project);
		personalDeatils.setOthersDetail(othersDetail);;

		when(userCVRepo.findAll()).thenReturn(Stream.of(personalDeatils).collect(Collectors.toList()));
		assertEquals(1, userCVServiceImpl.find().size());
	}

}
