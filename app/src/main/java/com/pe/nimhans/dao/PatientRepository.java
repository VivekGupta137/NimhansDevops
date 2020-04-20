package com.pe.nimhans.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pe.nimhans.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
