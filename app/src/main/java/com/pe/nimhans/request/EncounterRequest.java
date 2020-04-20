package com.pe.nimhans.request;

public class EncounterRequest {
	int patient_id;
	int doctor_id;
	
	public EncounterRequest(int patient_id, int doctor_id) {
		this.patient_id = patient_id;
		this.doctor_id = doctor_id;
	}
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	
}
