package com.pe.nimhans.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.nimhans.service.UserService;

@RestController
@CrossOrigin(origins= {"http://localhost:4200","localhost:4200"})
public class CurrentApi {
	@Autowired
	UserService user;
	
	@GetMapping("/current")
	public Authentication currentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth;
	}
	@GetMapping("/current/id")
	public long currentId() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();		
		return user.findByUsername(username);
	}
}
