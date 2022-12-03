package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repo.RegistrationRepo;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepo repo;
	
	public User saveUser(User user) {
		return repo.save(user);	
	}
	
}
