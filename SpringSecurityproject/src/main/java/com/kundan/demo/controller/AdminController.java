package com.kundan.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kundan.demo.model.User;
import com.kundan.demo.repository.UserRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
//	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping("/add")
	public String addUserByAdmin(@RequestBody User user) {
		System.out.println("user added......");
		String pwd=user.getPassword();
		String encryptPwd=passwordEncoder.encode(pwd);
		user.setPassword(encryptPwd);
		userRepository.save(user);
		return "user added successfully.....";
	}
	
	@GetMapping("/message")
    public String hello() {
        return ("<h1>Hello Welcome Admin..</h1>");
    }
	
//	@PreAuthorize("hasAnyRole('ADMIN')")
//    @GetMapping("/secured")
//    public String securedHello() {
//        return ("<h1>Secured Hello</h1>");
//    }

}
