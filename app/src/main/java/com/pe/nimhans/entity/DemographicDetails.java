package com.pe.nimhans.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
@Table(name="demographic_details")
public class DemographicDetails {	
	public void setDemo_id(Integer demo_id) {
		this.demo_id = demo_id;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer demo_id;
	
	@Column(name = "data")
	private String data;

	public DemographicDetails(String det) {
		this.data = det;
	}
 
	public DemographicDetails() {
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

	public Integer getDemo_id() {
		return demo_id;
	}
	
	
}