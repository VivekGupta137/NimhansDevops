package com.pe.nimhans.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pe.nimhans.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

}
