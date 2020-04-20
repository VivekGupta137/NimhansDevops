package com.pe.nimhans.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
public class ClinicalDetails {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer clinical_id;
	
	@Column(name = "data")
	private String data;
	
	public ClinicalDetails() {
	}
	
	public ClinicalDetails(String d) {
		data = d;
	}

	public Integer getClinical_id() {
		return clinical_id;
	}

	public void setClinical_id(Integer clinical_id) {
		this.clinical_id = clinical_id;
	}	

	public void setData(String data) {
		this.data = data;
	}
	
	public JsonNode getData() {
		return setJsonString(data);
	}
	public JsonNode setJsonString(String jsonString) {  // This is for JPA
	    // parse from String to JsonNode object
	    ObjectMapper mapper = new ObjectMapper();
	    JsonNode jn = null;
	    try {
	    	jn = mapper.readTree(jsonString);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return jn;
	}
	
}
