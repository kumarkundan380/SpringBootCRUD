package com.kundan.demo.servicecomponent;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kundan.demo.model.Employee;
import com.kundan.demo.repository.EmployeeRepository;
import com.kundan.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;
	String imageName;

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> findById(Long empId) {
		return employeeRepository.findById(empId);
	}

	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Optional<Employee> update(Long empId,Employee employee) {
	
		   Employee emp=employeeRepository.findById(empId).get();
		   emp.setFirstName(employee.getFirstName());
		   emp.setLastName(employee.getLastName());
		   emp.setEmail(employee.getEmail());
		   emp.setImageName(employee.getImageName());
		   employeeRepository.save(emp);
		   return  Optional.of(emp);
	}

	@Override
	public void delete(Employee employee) {
		employeeRepository.delete(employee);
		
	}
	@Override
	public MultipartFile uploadeImage(MultipartFile file){
		
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
