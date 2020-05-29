package com.pe.nimhans.rest;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.pe.nimhans.entity.ClinicalDetails;
import com.pe.nimhans.entity.DemographicDetails;
import com.pe.nimhans.entity.DischargeDetails;
import com.pe.nimhans.entity.Doctor;
import com.pe.nimhans.entity.Encounter;
import com.pe.nimhans.entity.NeurologicalDetails;
import com.pe.nimhans.entity.Patient;
import com.pe.nimhans.entity.PhysicalDetails;
import com.pe.nimhans.request.EncounterRequest;
import com.pe.nimhans.service.DoctorService;
import com.pe.nimhans.service.EncounterService;
import com.pe.nimhans.service.PatientService;

@RestController
@CrossOrigin(origins= {"http://localhost:4200","localhost:4200","http://52.179.181.118:4500"})
public class EncounterApi {
	@Autowired
	PatientService patient;
	@Autowired
	DoctorService doctor; 
	@Autowired
	EncounterService encounter;	

	@GetMapping("/encounters/all")
	public List<Encounter> getAllEncounter() {
		return encounter.findAll();
	}
	
	@GetMapping("/encounters")
	public List<Encounter> getAllEncounters(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();		
		int id = doctor.findIdByName(username);		
		return doctor.getAllEncounters(id);
	}
	
	@GetMapping("/encounters/{eid}")
	public Encounter getEncounter(@PathVariable int eid) {
		return encounter.findById(eid);
	}
	@PostMapping("/encounters")
	public int addEncounter(@RequestBody EncounterRequest theEncounterRequest) {
		Patient thePatient = patient.findById(theEncounterRequest.getPatient_id());
		Doctor theDoctor = doctor.findById(theEncounterRequest.getDoctor_id());
		Encounter theEncounter = new Encounter(thePatient,theDoctor);
		theEncounter.setStart_date(LocalDate.now());
		theEncounter.setFlag("open");
		encounter.save(theEncounter);
		return theEncounter.getEid();
	}
	@PostMapping("/encounters/clinical/{eid}")
	public void addEncounterDetails1(@PathVariable int eid,@RequestBody String theClinicalDetailsMap) {
		ClinicalDetails theClinicalDetails = new ClinicalDetails(theClinicalDetailsMap);
		Encounter e = encounter.findById(eid);
		if(e.getClinical_id() != null)
			theClinicalDetails.setClinical_id(e.getClinical_id().getClinical_id());
		e.setClinical_id(theClinicalDetails);
		encounter.save(e);
	}
	@PostMapping("/encounters/neurological/{eid}")
	public void addEncounterDetails2(@PathVariable int eid,@RequestBody String  theNeurologicalDetailsMap) {
		NeurologicalDetails theNeurologicalDetails = new NeurologicalDetails(theNeurologicalDetailsMap);
		Encounter e = encounter.findById(eid);
		if(e.getNeurological_id() != null)
			theNeurologicalDetails.setNeuro_id(e.getNeurological_id().getNeuro_id());
		e.setNeurological_id(theNeurologicalDetails);
		encounter.save(e);
	}
	@PostMapping("/encounters/physical/{eid}")
	public void addEncounterDetails3(@PathVariable int eid,@RequestBody String  thePhysicalDetailsMap) {
		PhysicalDetails thePhysicalDetails = new PhysicalDetails(thePhysicalDetailsMap);
		Encounter e = encounter.findById(eid);
		if(e.getPhysical_id() != null)
			thePhysicalDetails.setPhysical_id(e.getPhysical_id().getPhysical_id());
		e.setPhysical_id(thePhysicalDetails);
		encounter.save(e);
	}
	@PostMapping("/encounters/demographic/{eid}")
	public void addEncounterDetails4(@PathVariable int eid,@RequestBody String  theDemographicDetailsMap) {
		DemographicDetails theDemographicDetails = new DemographicDetails(theDemographicDetailsMap);
		Encounter e = encounter.findById(eid);
		if(e.getDemo_id() != null)
			theDemographicDetails.setDemo_id(e.getDemo_id().getDemo_id());
		e.setDemo_id(theDemographicDetails);
		encounter.save(e);
	}
	@PostMapping("/encounters/discharge/{eid}")
	public void addEncounterDetails5(@PathVariable int eid,@RequestBody String  theDischargeDetailsMap) {
		DischargeDetails theDischargeDetails = new DischargeDetails(theDischargeDetailsMap);
		Encounter e = encounter.findById(eid);
		if(e.getDischarge_id() != null)
			theDischargeDetails.setDischarge_id(e.getDischarge_id().getDischarge_id());
		e.setDischarge_id(theDischargeDetails);
		encounter.save(e);
	}
	@PostMapping("/encounters/finish/{eid}")
	public void addEncounterDetails(@PathVariable int eid) {
		Encounter e = encounter.findById(eid);
		e.setClosed_date(LocalDate.now());
		e.setFlag("closed");
		encounter.save(e);
	}
}
