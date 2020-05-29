package com.pe.nimhans.rest;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.nimhans.dao.DemoRepository;
import com.pe.nimhans.entity.ClinicalDetails;
import com.pe.nimhans.entity.Demo;
import com.pe.nimhans.entity.DemographicDetails;
import com.pe.nimhans.entity.DischargeDetails;
import com.pe.nimhans.entity.Doctor;
import com.pe.nimhans.entity.Ehrid_uhid_mapper;
import com.pe.nimhans.entity.Encounter;
import com.pe.nimhans.entity.NeurologicalDetails;
import com.pe.nimhans.entity.Patient;
import com.pe.nimhans.entity.PhysicalDetails;
import com.pe.nimhans.entity.User;
import com.pe.nimhans.service.DoctorService;
import com.pe.nimhans.service.EncounterService;
import com.pe.nimhans.service.PatientService;
import com.pe.nimhans.service.UhidService;
import com.pe.nimhans.service.UserService;

@RestController
@CrossOrigin
public class DummyData {
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
	@Autowired
	UserService userService;
	
	@GetMapping("/add_dummy")
	public String addDummy() {		
//		create 10 doctors
		Doctor[] doc = new Doctor[10];	
//		create 10 users
		User[] user = new User[10];	
		for (int i = 0; i < 10; i++) { 
			doc[i] = new Doctor("doc_"+i,"1000"+i,"doc_"+i+"@email.com","doc_"+i+"_addr","neuro_department",8000+i);
			user[i] = new User("user_"+i,"test123","ROLE_DOCTOR");
			doc[i].setUsername(user[i]);
			doctor.save(doc[i]);
		}
//		create 20 patients
		Patient[] pat = new Patient[20];
		Demo[] demo = new Demo[pat.length];
		Ehrid_uhid_mapper[] eu_map = new Ehrid_uhid_mapper[pat.length];
		for (int i = 0; i < 20; i++) {
			pat[i] = new Patient("pat_"+i,"1000"+i,20+i,"male");
			pat[i].setDoctor(doc[(i+2)%10]);
			patient.save(pat[i]);
			System.out.println("\npatient saved\n");
			
			demo[i] = new Demo(1000+i);
			demorepo.save(demo[i]);
			System.out.println("\ndemo saved\n");
			
			eu_map[i] = new Ehrid_uhid_mapper(pat[i],demo[i]);
			uhserve.save(eu_map[i]);
		}
		
//		create 40 encounters
		Encounter[] enc = new Encounter[40];
		for (int i = 0; i < enc.length; i++) {
			enc[i] = new Encounter(pat[(i+4)%20],pat[(i+4)%20].getDoctor(),LocalDate.now(),LocalDate.now(),"closed");
			String det = "{\"details_for_pat_\":\""+ Integer.toString(i+4)+"\"}";
			ClinicalDetails cd = new ClinicalDetails(det);
			NeurologicalDetails nd = new NeurologicalDetails(det);
			PhysicalDetails pd = new PhysicalDetails(det);
			DemographicDetails dd = new DemographicDetails(det);
			DischargeDetails disd = new DischargeDetails(det);
			enc[i].setClinical_id(cd);			
			enc[i].setNeurological_id(nd);
			enc[i].setPhysical_id(pd); 
			enc[i].setDemo_id(dd);
			enc[i].setDischarge_id(disd);
			encounter.save(enc[i]);
		}
		return "successful";
	}
}
