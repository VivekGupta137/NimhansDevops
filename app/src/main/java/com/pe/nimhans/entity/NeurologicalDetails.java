package com.pe.nimhans.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
public class NeurologicalDetails {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer neuro_id;
	
	@Column(name = "data")
	private String data;
	
	public NeurologicalDetails() {
	}

	public NeurologicalDetails(String det) {
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

	public Integer getNeuro_id() {
		return neuro_id;
	}
	public void setNeuro_id(Integer neuro_id) {
		this.neuro_id = neuro_id;
	}
}
