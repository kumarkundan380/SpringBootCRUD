package com.kundan.demo.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kundan.demo.dto.ProfileDTO;
import com.kundan.demo.exception.ResourceNotFoundException;
import com.kundan.demo.model.Profile;
import com.kundan.demo.service.ProfileService;

@RestController
@CrossOrigin
@RequestMapping("/profile")
public class ProfileController {
	
	@Autowired
	ProfileService profileService;
	
	/* To save a profile*/
	@PostMapping("/add")
	public Profile add(@RequestBody ProfileDTO profileDTO){
		return profileService.add(profileDTO);
	}
	
	/* Get all profile */
	@GetMapping("/findAll")
	public List<Profile> findAll(){
		return profileService.findAll();
	}
	
	/* Get a profile by id*/
	@GetMapping("/fetch/{id}")
	public Profile getprofileByIds(@PathVariable(value = "id")int id)throws ResourceNotFoundException {
		return profileService.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found :: " + id));
	}
	
	/* Update a profile by id*/
	@PutMapping("/update/{id}")
	public Profile updateEmployee(@PathVariable(value = "id") int id, @Valid @RequestBody ProfileDTO profileDTO) throws ResourceNotFoundException {
		return profileService.update(id,profileDTO).orElseThrow(() -> new ResourceNotFoundException("User not found :: " + id));
	}
	
//	/* Delete a profile by id*/
//	@DeleteMapping("/delete/{id}")
//	public void deleteEmployeeById(@PathVariable(value = "id")int id) throws ResourceNotFoundException {
//		profileService.delete(profileService.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found :: " + id)));		
//	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Profile> deleteEmployeeById(@PathVariable(value = "id") int id){
		return profileService.delete(id);
	}
	
	/* Upload profile image in folder*/
	@PostMapping("/uploadImage")
	public MultipartFile uploadeImage(@RequestParam("myFile") MultipartFile file) throws Exception {
		return profileService.uploadeImage(file);
	}
	
	/* Fetch profile image from folder*/
	@GetMapping("/getImage")
	public ResponseEntity<Map<String, String>> getImage(){
		return profileService.getImage();
	}
}
