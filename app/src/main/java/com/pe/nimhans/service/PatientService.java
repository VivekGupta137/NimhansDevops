package com.pe.nimhans.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pe.nimhans.entity.Encounter;
import com.pe.nimhans.entity.Patient;

@Service
public interface PatientService {
	public List<Patient> findAll(int docId); // list patients of doctor with id = docId
	public List<Patient> findAll(); // lists all the patients
	public List<Encounter> findAllEncounters(int patientId);
	public Patient findById(int id);
	public void save(Patient thePatient);
	public void deleteById(int id);
}
