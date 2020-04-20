package com.pe.nimhans.entity;

import java.io.Serializable;

import javax.persistence.Id;

public class MapperId implements Serializable {
	@Id
	int uh_id;
	
	@Id
	int ehr_id;
	
    public MapperId() {
    	
    }    
}
