package com.pe.nimhans.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "patient")
//@JsonIgnoreProperties(ignoreUnknown = true) 
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ehr_id")
	int ehrId;
	
	@Column(name = "pname")
	String pname;
	
	@Column(name = "pcontact")
	String pcontact;
	
	@Column(name = "age")
	int age;
	
	@Column(name = "gender")
	String gender;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "doctor")
	Doctor doctor;
	
	@OneToMany(mappedBy="encounterpatient")
//	@JsonIgnore
	List<Encounter> encounters;
	
	@OneToOne(mappedBy="patient")
	@JsonIgnore
	Ehrid_uhid_mapper ehrid_uhid;

	public Ehrid_uhid_mapper getEhrid_uhid() {
		return ehrid_uhid;
	}

	public void setEhrid_uhid(Ehrid_uhid_mapper ehrid_uhid) {
		this.ehrid_uhid = ehrid_uhid;
	}

	//	Constructors
	public Patient(String pname, String pcontact, int age, String gender) {
		this.pname = pname;
		this.pcontact = pcontact;
		this.age = age;
		this.gender = gender;
	}

	public Patient(String pname, String pcontact, int age, String gender, Doctor doctor) {
		super();
		this.pname = pname;
		this.pcontact = pcontact;
		this.age = age;
		this.gender = gender;
		this.doctor = doctor;
	}

	public Patient() {	}
	
	public int getEhrId() {
		return ehrId;
	}

	public void setEhrId(int ehrId) {
		this.ehrId = ehrId;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public String getPcontact() {
		return pcontact;
	}

	public void setPcontact(String pcontact) {
		this.pcontact = pcontact;
	}

	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Doctor getDoctor() {
		return doctor;
	}


	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	public List<Encounter> getEncounters() {
		return encounters;
	}

	public void setEncounters(List<Encounter> encounters) {
		this.encounters = encounters;
	}

	@Override
	public String toString() {
		return "Patient [ehrId=" + ehrId + ", pname=" + pname + ", pcontact=" + pcontact + ", age=" + age + ", gender="
				+ gender + ", ehrid_uhid=" + ehrid_uhid + "]";
	}	
	
}
