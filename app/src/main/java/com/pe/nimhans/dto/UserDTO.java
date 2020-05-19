package com.pe.nimhans.dto;

import com.pe.nimhans.entity.Doctor;

public class UserDTO {
	private Long id;
	private String username;
	private String role;
	private boolean enabled;
	private Doctor doctor;
	
	public UserDTO(Long id, String username, String role, boolean enabled, Doctor doctor) {
		this.id = id;
		this.username = username;
		this.role = role;
		this.enabled = enabled;
		this.doctor = doctor;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getRole() {
		return role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public Doctor getDoctor() {
		return doctor;
	}
	
}
