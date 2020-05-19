package com.pe.nimhans.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pe.nimhans.dto.UserDTO;
import com.pe.nimhans.entity.Doctor;
import com.pe.nimhans.entity.User;

@Service
public interface UserService {
	public long findByUsername(String username);
	public void save(User theUser, Doctor theDoctor);
	public List<UserDTO> getAll();
	public void enable(User theUser);
	public void disable(User theUser);
}
