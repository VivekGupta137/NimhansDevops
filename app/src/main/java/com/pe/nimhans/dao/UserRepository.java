package com.pe.nimhans.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pe.nimhans.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
