package com.pe.nimhans.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
//@IdClass(MapperId.class)
@Table(name = "ehrid_uhid_mapper")
public class Ehrid_uhid_mapper {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;


	@OneToOne
	@JoinColumn(name = "ehr_id")	
	private Patient patient;
	
	
	@OneToOne
	@JoinColumn(name = "uh_id")
	private Demo demo;
	public Ehrid_uhid_mapper() {
		   
	}

	public Ehrid_uhid_mapper(Patient patient, Demo demo) {
		this.patient = patient;
		this.demo = demo;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Demo getDemo() {
		return demo;
	}

	public void setDemo(Demo demo) {
		this.demo = demo;
	}
   
}
