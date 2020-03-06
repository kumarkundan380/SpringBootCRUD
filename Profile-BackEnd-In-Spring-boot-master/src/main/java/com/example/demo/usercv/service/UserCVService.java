package com.example.demo.usercv.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.usercv.bean.PersonalDetails;
import com.example.demo.usercv.dto.UserCVDTO;

public interface UserCVService{
	public PersonalDetails add(UserCVDTO userCVDTO);
	public List<PersonalDetails> find();
	public String uploade(MultipartFile file) throws Exception;
}
