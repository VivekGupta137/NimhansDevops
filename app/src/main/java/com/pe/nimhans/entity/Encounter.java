package com.pe.nimhans.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="encounter")
public class Encounter {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer eid;
		
	@ManyToOne
	@JoinColumn(name = "ehr_id")
	@JsonIgnore
	private Patient encounterpatient;

	@ManyToOne
	@JoinColumn(name = "emp_id")
	private Doctor encounterDoctor;
//	private Doctor authorisingDoctor;
	
	private LocalDate start_date;
	private LocalDate closed_date;
	private String flag;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "neurological_id")
	private NeurologicalDetails neurological_id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "clinical_id")
	private ClinicalDetails clinical_id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "physical_id")
	private PhysicalDetails physical_id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "demo_id")
	private DemographicDetails demo_id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "discharge_id")
	private DischargeDetails discharge_id;	
	
	public Encounter() {
	}
	
	public Encounter(Patient encounterpatient, Doctor encounterDoctor) {
		this.encounterpatient = encounterpatient;
		this.encounterDoctor = encounterDoctor;
	}
	
	public Encounter(Patient encounterpatient, Doctor encounterDoctor, LocalDate start_date, LocalDate closed_date,
			String flag) {
		this.encounterpatient = encounterpatient;
		this.encounterDoctor = encounterDoctor;
		this.start_date = start_date;
		this.closed_date = closed_date;
		this.flag = flag;
	}

	public Encounter(Patient encounterpatient, Doctor encounterDoctor, LocalDate start_date, LocalDate closed_date, String flag,
			NeurologicalDetails neurological_id, ClinicalDetails clinical_id, PhysicalDetails physical_id,
			DemographicDetails demo_id, DischargeDetails discharge_id) {
		super();
		this.encounterpatient = encounterpatient;
		this.encounterDoctor = encounterDoctor;
		this.start_date = start_date;
		this.closed_date = closed_date;
		this.flag = flag;
		this.neurological_id = neurological_id;
		this.clinical_id = clinical_id;
		this.physical_id = physical_id;
		this.demo_id = demo_id;
		this.discharge_id = discharge_id;
	}

	public Patient getEncounterpatient() {
		return encounterpatient;
	}

	public void setEncounterpatient(Patient encounterpatient) {
		this.encounterpatient = encounterpatient;
	}

	public Doctor getEncounterDoctor() {
		return encounterDoctor;
	}

	public void setEncounterDoctor(Doctor encounterDoctor) {
		this.encounterDoctor = encounterDoctor;
	}

	public LocalDate getStart_date() {
		return start_date;
	}

	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}

	public LocalDate getClosed_date() {
		return closed_date;
	}

	public void setClosed_date(LocalDate closed_date) {
		this.closed_date = closed_date;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public NeurologicalDetails getNeurological_id() {
		return neurological_id;
	}

	public void setNeurological_id(NeurologicalDetails neurological_id) {
		this.neurological_id = neurological_id;
	}

	public ClinicalDetails getClinical_id() {
		return clinical_id;
	}

	public void setClinical_id(ClinicalDetails clinical_id) {
		this.clinical_id = clinical_id;
	}

	public PhysicalDetails getPhysical_id() {
		return physical_id;
	}

	public void setPhysical_id(PhysicalDetails physical_id) {
		this.physical_id = physical_id;
	}

	public DemographicDetails getDemo_id() {
		return demo_id;
	}

	public void setDemo_id(DemographicDetails demo_id) {
		this.demo_id = demo_id;
	}

	public DischargeDetails getDischarge_id() {
		return discharge_id;
	}

	public void setDischarge_id(DischargeDetails discharge_id) {
		this.discharge_id = discharge_id;
	}

	public Integer getEid() {
		return eid;
	}	
}
