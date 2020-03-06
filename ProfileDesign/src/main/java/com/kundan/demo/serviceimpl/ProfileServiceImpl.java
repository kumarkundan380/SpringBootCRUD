package com.kundan.demo.serviceimpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.kundan.demo.dto.ProfileDTO;
import com.kundan.demo.model.EducationDetail;
import com.kundan.demo.model.Exprience;
import com.kundan.demo.model.Profile;
import com.kundan.demo.repository.ProfileRepository;
import com.kundan.demo.service.ProfileService;

import lombok.Getter;
import lombok.Setter;

@Service
public class ProfileServiceImpl implements ProfileService{
	
	@Autowired
	private ProfileRepository profileRepository;
	
	private String imageName;
	
	public static final Logger LOGGER=org.slf4j.LoggerFactory.getLogger(ProfileServiceImpl.class);

	@Override
	public Profile add(ProfileDTO profileDTO) {
		
		LOGGER.info("Add method is call");
		
		Exprience exprience=new Exprience();
		
		exprience.setPresentDesignation(profileDTO.getPresentDesignation());
		exprience.setCompanyName(profileDTO.getCompanyName());
		exprience.setPeriod(profileDTO.getPeriod());
		
		EducationDetail educationDetail=new EducationDetail();
		
		educationDetail.setSscBoard(profileDTO.getSscBoard());
		educationDetail.setSscPercentage(profileDTO.getSscPercentage());
		educationDetail.setSscYear(profileDTO.getSscYear());
		
		educationDetail.setHscBoard(profileDTO.getHscBoard());
		educationDetail.setHscPercentage(profileDTO.getHscPercentage());
		educationDetail.setHscYear(profileDTO.getHscYear());
		
		educationDetail.setBscBoard(profileDTO.getBscBoard());
		educationDetail.setBscPercentage(profileDTO.getBscPercentage());
		educationDetail.setBscYear(profileDTO.getBscYear());
		
		educationDetail.setPgBoard(profileDTO.getPgBoard());
		educationDetail.setPgPercentage(profileDTO.getPgPercentage());
		educationDetail.setPgYear(profileDTO.getPgYear());
		
		Profile profile=new Profile();
		
		profile.setFirstName(profileDTO.getFirstName());
		profile.setLastName(profileDTO.getLastName());
		profile.setEmail(profileDTO.getEmail());
		profile.setDesignation(profileDTO.getDesignation());
		profile.setMobileNo(profileDTO.getMobileNo());
		profile.setSkill(profileDTO.getSkill());
		profile.setHobbies(profileDTO.getHobbies());
		profile.setAddress(profileDTO.getAddress());
		profile.setLanguages(profileDTO.getLanguages());
		profile.setImageName(profileDTO.getImageName());
		
		profile.setExprience(exprience);
		profile.setEducation(educationDetail);
		
		Profile saveProfile=profileRepository.save(profile);
		
		LOGGER.info("Record is inserted");
		return saveProfile;
		
		
	}

	@Override
	public List<Profile> findAll() {
		
		LOGGER.info("FindAll method is call");
		
		return profileRepository.findAll();
	}
	
	@Override
	public Optional<Profile> findById(int id) {
		
		LOGGER.info("FindById method is call");
		return profileRepository.findById(id);
	}

	@Override
	public Optional<Profile> update(int id,ProfileDTO profileDTO) {
		
		LOGGER.info("Update method is call");
		Exprience exprience=new Exprience();
		
		exprience.setPresentDesignation(profileDTO.getPresentDesignation());
		exprience.setCompanyName(profileDTO.getCompanyName());
		exprience.setPeriod(profileDTO.getPeriod());
		
		EducationDetail educationDetail=new EducationDetail();
		
		educationDetail.setSscBoard(profileDTO.getSscBoard());
		educationDetail.setSscPercentage(profileDTO.getSscPercentage());
		educationDetail.setSscYear(profileDTO.getSscYear());
		
		educationDetail.setHscBoard(profileDTO.getHscBoard());
		educationDetail.setHscPercentage(profileDTO.getHscPercentage());
		educationDetail.setHscYear(profileDTO.getHscYear());
		
		educationDetail.setBscBoard(profileDTO.getBscBoard());
		educationDetail.setBscPercentage(profileDTO.getBscPercentage());
		educationDetail.setBscYear(profileDTO.getBscYear());
		
		educationDetail.setPgBoard(profileDTO.getPgBoard());
		educationDetail.setPgPercentage(profileDTO.getPgPercentage());
		educationDetail.setPgYear(profileDTO.getPgYear());
			
		Profile profile=profileRepository.findById(id).get();
			
		profile.setFirstName(profileDTO.getFirstName());
		profile.setLastName(profileDTO.getLastName());
		profile.setEmail(profileDTO.getEmail());
		profile.setDesignation(profileDTO.getDesignation());
		profile.setMobileNo(profileDTO.getMobileNo());
		profile.setSkill(profileDTO.getSkill());
		profile.setHobbies(profileDTO.getHobbies());
		profile.setAddress(profileDTO.getAddress());
		profile.setLanguages(profileDTO.getLanguages());
		profile.setImageName(profileDTO.getImageName());
			
		profile.setExprience(exprience);
		profile.setEducation(educationDetail);
			
		profileRepository.save(profile);
		return  Optional.of(profile);
//		return Optional.of(profileRepository.save(profile));
	}

//	@Override
//	public void delete(Profile profile) {
//		
//		LOGGER.info("Delete method is call");
//		profileRepository.delete(profile);
//		
//	}

	@Override
	public ResponseEntity<Profile> delete(@PathVariable(value="id") int id){
		Profile profile=profileRepository.findById(id).get();
		if(profile==null) {
			return ResponseEntity.notFound().build();
		}
		profileRepository.delete(profile);
		return ResponseEntity.ok().build();
	}
	
	@Override
	public MultipartFile uploadeImage(MultipartFile file){
		
		LOGGER.info("Upload Image method is call");
		
		String folder="/home/kundan/Desktop/Image/";
		imageName=file.getOriginalFilename();
		Path path=Paths.get(folder+file.getOriginalFilename());
		try {
		Files.write(path,file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return file;
	}
	
	@Override
	public ResponseEntity<Map<String, String>> getImage() {
		
		LOGGER.info("Get image method is call");
		
		Map<String,String> images=new HashMap<String,String>();
		File fileFolder=new File("/home/kundan/Desktop/Image");
		if(fileFolder!=null) {
			for(final File file:fileFolder.listFiles()) {
				if(!file.isDirectory()) {
					String encodeBase64=null;
					try {
						String extension=FilenameUtils.getExtension(file.getName());
						String fname=FilenameUtils.getName(file.getName());
						FileInputStream fileInputStream=new FileInputStream(file);
						byte[] bytes=new byte[(int)file.length()];
						fileInputStream.read(bytes);
						encodeBase64=java.util.Base64.getEncoder().encodeToString(bytes);
						images.put(fname,"data:image/"+extension+";base64,"+encodeBase64);
						fileInputStream.close();
					} 
					catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		//System.out.println(images.size());
		return new ResponseEntity<Map<String,String>>(images,HttpStatus.OK);
	}

	

}
