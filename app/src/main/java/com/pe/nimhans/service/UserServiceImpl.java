package com.pe.nimhans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pe.nimhans.dao.UserRepository;

@Repository
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository repo;
	@Override
	public long findByUsername(String username) {
		return repo.findByUsername(username).getId();
	}

}
