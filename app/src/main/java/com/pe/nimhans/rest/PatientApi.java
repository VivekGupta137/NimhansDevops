package com.pe.nimhans.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pe.nimhans.entity.Doctor;
import com.pe.nimhans.entity.Patient;
import com.pe.nimhans.service.DoctorService;
import com.pe.nimhans.service.EncounterService;
import com.pe.nimhans.service.PatientService;

@RestController
@CrossOrigin(origins= {"http://localhost:4200","localhost:4200"})
public class PatientApi {
	@Autowired
	PatientService patient;
	@Autowired
	DoctorService doctor;
	@Autowired
	EncounterService encounter;
	
		
	@GetMapping("/patients/all")
	public List<Patient> getAllPatients() {
		return patient.findAll();
	}
	@GetMapping("/doctors/all")
	public List<Doctor> getAllDoctors() {
		return doctor.findAll();
	}
	
	@GetMapping("/patients")
	public List<Patient> getCurrentDoctorPatients() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		
		int id = doctor.findIdByName(username);
		
		return patient.findAll(id);
	}
		
	@PostMapping("/patients")
	public void addPatient(@RequestBody Patient thePatient) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();		
		int id = doctor.findIdByName(username);
		
		thePatient.setDoctor(doctor.findById(id));
		
		patient.save(thePatient);
	}
	@PostMapping("/patients/{did}")
	public void addPatientForId(@RequestBody Patient thePatient,
			@PathVariable int did) {			
		thePatient.setDoctor(doctor.findById(did));
		
		patient.save(thePatient);
	}	
	
	@PutMapping("/patients")
	public void updatePatient(@RequestBody Patient thePatient) {
		patient.save(thePatient);
	}
	
	@GetMapping("/patients/{pid}")
	public Patient getThePatient(@PathVariable int pid) {
		return patient.findById(pid);
	}	
		
}
