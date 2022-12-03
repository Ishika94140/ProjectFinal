package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repo.RegistrationRepo;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {
	
	@Autowired
	private RegistrationRepo registrationRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostMapping("/register")
	public ResponseEntity<User> submitRegister(@RequestBody User user) {
		
	user.setPassword(passwordEncoder.encode(user.getPassword()));
		
	/*BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	user.setPassword(passwordEncoder.encode(user.getPassword()));*/
	
	return ResponseEntity.ok(registrationRepo.save(user));
	
	}	
}
