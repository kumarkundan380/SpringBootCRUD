package com.example.demo.usercv.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.usercv.bean.PersonalDetails;
import com.example.demo.usercv.dto.UserCVDTO;
import com.example.demo.usercv.service.UserCVServiceImpl;

@RestController
@CrossOrigin
public class UserCVController {

	@Autowired
	UserCVServiceImpl userCVServiceImpl;

	/*
	 * Method for insert record in database
	*/
	@PostMapping("/add")
	public PersonalDetails add(@RequestBody UserCVDTO userCVDTO) {
		return userCVServiceImpl.add(userCVDTO);
	}

	/*
	 * This method for retrive all record from database
	*/
	@GetMapping("/find")
	public List<PersonalDetails> find() {
		return userCVServiceImpl.find();
	}

	/*
	 * This method for uploading the image in specified  folder
	*/
	@PostMapping("/fileUploade")
	public String uploade(@RequestBody MultipartFile file) throws Exception {
		
		return userCVServiceImpl.uploade(file);
	}
	
	@GetMapping("/search")
	public PersonalDetails search(String email){
		return userCVServiceImpl.search(email);
		
	}

}
