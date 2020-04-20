package com.pe.nimhans.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
public class PhysicalDetails {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer physical_id;
	
	@Column(name = "data")
	private String data;

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

	public Integer getPhysical_id() {
		return physical_id;
	}

	public PhysicalDetails() {
		super();
	}

	public PhysicalDetails(String det) {
		super();
		this.data = det;
	}
	
	public void setPhysical_id(Integer physical_id) {
		this.physical_id = physical_id;
	}

}
