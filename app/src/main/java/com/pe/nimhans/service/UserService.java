package com.pe.nimhans.service;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
	public long findByUsername(String username);
}
