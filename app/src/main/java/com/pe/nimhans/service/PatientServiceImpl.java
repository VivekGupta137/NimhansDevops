package com.pe.nimhans.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pe.nimhans.dao.DoctorRepository;
import com.pe.nimhans.dao.EncounterRepository;
import com.pe.nimhans.dao.PatientRepository;
import com.pe.nimhans.entity.Doctor;
import com.pe.nimhans.entity.Encounter;
import com.pe.nimhans.entity.Patient;

@Repository
public class PatientServiceImpl implements PatientService {
	@Autowired
	EntityManager em;
	
	@Autowired
	PatientRepository repo;
	
	@Autowired
	DoctorRepository docRepo;
	
	@Autowired
	EncounterRepository encRepo;
	
	@Override
	public List<Patient> findAll() {
		return repo.findAll();
	}

	@Override
	public Patient findById(int id) {
		if(!repo.findById(id).isPresent())	return null;
		return repo.findById(id).get();
	}

	@Override
	public void save(Patient thePatient) {
		repo.save(thePatient);		
	}

	@Override
	public void deleteById(int id) {
		repo.deleteById(id);
	}

	@Override
	public List<Patient> findAll(int docId) {
		Optional<Doctor> result = docRepo.findById(docId);
		if(!result.isPresent()) return null;
		return result.get().getPatient();
	}

	@Override
	public List<Encounter> findAllEncounters(int patientId) {
		Optional<Patient> result = repo.findById(patientId);
		if(!result.isPresent()) return null;
		return result.get().getEncounters();
	}
}
