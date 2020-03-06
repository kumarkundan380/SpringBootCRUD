package com.kundan.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kundan.demo.model.User;
import com.kundan.demo.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	 @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        Optional<User> optionalUser = userRepository.findByUserName(username);

	        optionalUser
	                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
	        return optionalUser
	                .map(CustomUserDetails::new).get();
	    }

}
