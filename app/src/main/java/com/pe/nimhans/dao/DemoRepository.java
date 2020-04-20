package com.pe.nimhans.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pe.nimhans.entity.Demo;

public interface DemoRepository extends JpaRepository<Demo, Integer> {

}
