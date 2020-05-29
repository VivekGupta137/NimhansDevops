package com.pe.nimhans.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.nimhans.dao.DemoRepository;
import com.pe.nimhans.entity.Encounter;
import com.pe.nimhans.entity.Patient;
import com.pe.nimhans.service.DoctorService;
import com.pe.nimhans.service.EncounterService;
import com.pe.nimhans.service.PatientService;
import com.pe.nimhans.service.UhidService;

@RestController
@RequestMapping("/test")
@CrossOrigin(origins= {"http://localhost:4200","localhost:4200","http://52.179.181.118:4500","52.179.181.118:4500"})
public class TestApi {
	@Autowired
	PatientService patient;
	@Autowired
	DoctorService doctor;
	@Autowired
	EncounterService encounter;
	@Autowired
	UhidService uhserve;
	@Autowired
	DemoRepository demorepo;
	
	
	@GetMapping("/getPatient/{uh_id}")
	public Patient getPatientByUhid(@PathVariable Integer uh_id) {
		System.out.println("\ngetPatientByUhid\n");
		return uhserve.getPatientByUhrid(uh_id);
	}
	
	@GetMapping("/getEncounters/{uh_id}")
	public List<Encounter> getEncountersByUhid(@PathVariable Integer uh_id) {
		System.out.println("\ngetPatientByUhid\n");
		return uhserve.getEncounterByUhrid(uh_id);
	}
	
}
