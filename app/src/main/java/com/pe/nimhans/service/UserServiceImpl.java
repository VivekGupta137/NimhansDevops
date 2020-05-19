package com.pe.nimhans.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.pe.nimhans.dao.UserRepository;
import com.pe.nimhans.dto.UserDTO;
import com.pe.nimhans.entity.Doctor;
import com.pe.nimhans.entity.User;

@Repository
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository repo;
	@Override
	public long findByUsername(String username) { 
		return repo.findByUsername(username).getId();
	}
	@Override
	public void save(User theUser, Doctor theDoctor) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		theUser.setPassword(encoder.encode(theUser.getPassword()));
		theUser.setDoctor(theDoctor);
		repo.save(theUser);
	}
	@Override
	public List<UserDTO> getAll() {
		List<User> users = repo.findAll();
		List<UserDTO> usersdto = new ArrayList<>();
		for(User user: users)
			usersdto.add(new UserDTO(user.getId(), user.getUsername(), user.getRole(), user.isEnabled(),user.getDoctor())); 
		return usersdto;
	}
	@Override
	public void enable(User theUser) {
		theUser.setEnabled(true);
	}
	@Override
	public void disable(User theUser) {
		theUser.setEnabled(false);
	}

}
