package com.pe.nimhans.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="doctor")
public class Doctor {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer emp_id;
		private String dname;
	 	private String dcontact;
	 	private String demail;
	 	private String daddress;
	 	private String department;
	 	private Integer unit;
	 	
	 	@OneToMany(mappedBy = "doctor")	
	 	@JsonIgnore
	    private List<Patient> patient;
	 	
	 	@OneToMany(mappedBy = "encounterDoctor")
		@JsonIgnore
		private List<Encounter> encounters;
	 	
		@OneToOne(cascade = CascadeType.ALL)
	 	@JoinColumn(name="username")
		@JsonIgnore
	 	User username;
	 	
	 	public Doctor() {
	 		
	 	}
	 	
	 	
	 	public String getDepartment() {
			return department;
		}


		public void setDepartment(String department) {
			this.department = department;
		}


		public Integer getUnit() {
			return unit;
		}


		public void setUnit(Integer unit) {
			this.unit = unit;
		}


		public Doctor(String dname, String dcontact, String demail, String daddress, String department, Integer unit) {
			super();
			this.dname = dname;
			this.dcontact = dcontact;
			this.demail = demail;
			this.daddress = daddress;
			this.department = department;
			this.unit = unit;
		}


		public Doctor(String dname, String dcontact, String demail, String daddress) {
	 		this.dname = dname;
	 		this.dcontact = dcontact;
	 		this.daddress = daddress;
	 		this.demail = demail;
	 	}

		public String getDname() {
			return dname;
		}

		public void setDname(String dname) {
			this.dname = dname;
		}

		public String getDcontact() {
			return dcontact;
		}

		public void setDcontact(String dcontact) {
			this.dcontact = dcontact;
		}

		public String getDemail() {
			return demail;
		}

		public void setDemail(String demail) {
			this.demail = demail;
		}

		public String getDaddress() {
			return daddress;
		}

		public void setDaddress(String daddress) {
			this.daddress = daddress;
		}

		public List<Patient> getPatient() {
			return patient;
		}

		public void setPatient(List<Patient> patient) {
			this.patient = patient;
		}
		
		public Integer getEmp_id() {
			return emp_id;
		}

		public List<Encounter> getEncounters() {
			return encounters;
		}

		public void setEncounters(List<Encounter> encounters) {
			this.encounters = encounters;
		}


		public User getUsername() {
			return username;
		}


		public void setUsername(User username) {
			this.username = username;
		}
		

}
