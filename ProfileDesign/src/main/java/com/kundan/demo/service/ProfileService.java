package com.kundan.demo.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.kundan.demo.dto.ProfileDTO;
import com.kundan.demo.model.Profile;

public interface ProfileService {
	
	public Profile add(ProfileDTO profileDTO);
	
	public List<Profile> findAll();
	
	public Optional<Profile> findById(int id);
	
	public Optional<Profile> update(int id,ProfileDTO profileDTO);
	
//	public void delete(Profile profile);
	
	public ResponseEntity<Profile> delete(@PathVariable(value="id") int id);
	
	public MultipartFile uploadeImage(MultipartFile file);
	
	public ResponseEntity<Map<String, String>> getImage(); 

}
