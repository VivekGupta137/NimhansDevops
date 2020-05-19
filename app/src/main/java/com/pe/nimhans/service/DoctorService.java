package com.pe.nimhans.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pe.nimhans.entity.Doctor;
import com.pe.nimhans.entity.Encounter;

@Service
public interface DoctorService {
	public List<Doctor> findAll(); // lists all the doctors
	public Doctor findById(int id);
	public int save(Doctor theDoctor);
	public void deleteById(int id);
	public int findIdByName(String username);
	public List<Encounter> getAllEncounters(int docId);
}
