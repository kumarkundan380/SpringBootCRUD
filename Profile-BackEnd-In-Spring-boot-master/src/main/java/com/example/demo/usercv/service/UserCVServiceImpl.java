package com.example.demo.usercv.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.usercv.bean.Education;
import com.example.demo.usercv.bean.OthersDetail;
import com.example.demo.usercv.bean.PersonalDetails;
import com.example.demo.usercv.bean.ProjectDetails;
import com.example.demo.usercv.bean.Skills;
import com.example.demo.usercv.dto.UserCVDTO;
import com.example.demo.usercv.repo.UserCVRepo;

@Service
public class UserCVServiceImpl implements UserCVService {

	@Autowired
	UserCVRepo userCVRepo;
	
	String email;
	
	public static final Logger LOGGER=org.slf4j.LoggerFactory.getLogger(UserCVServiceImpl.class);

	/*
	 * Defination body of add method for inserting the record
	 */
	public PersonalDetails add(UserCVDTO userCVDTO) {
		email=userCVDTO.getEmail();
		ProjectDetails project = new ProjectDetails();

		project.setTitle(userCVDTO.getTitle());
		project.setDescription(userCVDTO.getDescription());

		Skills skill = new Skills();

		skill.setPrograming(userCVDTO.getPrograming());
		skill.setWebTech(userCVDTO.getWebTech());
		skill.setDbs(userCVDTO.getDbs());

		Education education = new Education();
		education.setEducation(userCVDTO.getEducation());

		OthersDetail othersDetail = new OthersDetail();
		othersDetail.setAbout(userCVDTO.getAbout());
		othersDetail.setAchievement(userCVDTO.getAchievement());
		othersDetail.setDesignation(userCVDTO.getDesignation());
		othersDetail.setExperience(userCVDTO.getExperience());
		othersDetail.setOrganisation(userCVDTO.getOrganisation());

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

		personalDeatils.setOthersDetail(othersDetail);

		PersonalDetails personalDetails1 = userCVRepo.save(personalDeatils);

		LOGGER.info("Record is inserted");
		return personalDetails1;

	}

//	public PersonalDetails add1(PersonalDetails personalDetails) {
//		System.out.println(personalDetails);
//		System.out.println(userCVRepo);
//		return userCVRepo.save(personalDetails);
//	}

	/*
	 * defination body of find method for fetch the record
	 */
	public List<PersonalDetails> find() {
		LOGGER.info("FindAll method is call");
		return (List<PersonalDetails>) userCVRepo.findAll();

	}

	/*
	 * defination body of uploade method for store the image in folder
	 */
	public String uploade(MultipartFile file) throws Exception {
		System.out.println(email);
		String fileName=file.getOriginalFilename();
		if(fileName.endsWith(".png"))
			fileName=email+".png";
		else if(fileName.endsWith(".jpg"))
			fileName=email+".jpg";
		else if(fileName.endsWith(".jpeg"))
			fileName=email+".jpeg";
		File convertFile = new File("/home/bhusan/Desktop/uploadedImage",fileName);
		System.out.println(file.getOriginalFilename());
		convertFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(convertFile);
		fout.write(file.getBytes());
		System.out.println(file.getBytes().length);
		fout.close();
		LOGGER.info("Image is Uploaded");
		return "uploaded";
	}
	
	public PersonalDetails search(String email){
		PersonalDetails personalDetails = userCVRepo.findByEmail(email);
		
		//personalDetails.setFile(fin);
		LOGGER.info("Search method is invoke");
		return personalDetails;
	}

}
