package com.pe.nimhans.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
public class DischargeDetails {
	public void setDischarge_id(Integer discharge_id) {
		this.discharge_id = discharge_id;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer discharge_id;
	
	@Column(name = "data")
	private String data;	

	public DischargeDetails() {
	}

	public DischargeDetails(String det) {
		this.data = det;
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

	public void setData(String data) {
		this.data = data;
	}

	public Integer getDischarge_id() {
		return discharge_id;
	}
	
	
}
