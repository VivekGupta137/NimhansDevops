package com.pe.nimhans.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "demo")
public class Demo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "uh_id")
	private Integer uh_id;
	
	@OneToOne(mappedBy="demo")
	@JsonIgnore
	Ehrid_uhid_mapper theMapper;
	
	public Demo() {
	}
	public Demo(int uh_id) {
		this.uh_id = uh_id;
	}
	
	public Ehrid_uhid_mapper getTheMapper() {
		return theMapper;
	}
	public void setTheMapper(Ehrid_uhid_mapper theMapper) {
		this.theMapper = theMapper;
	}
	

	public Integer getUh_id() {
		return uh_id;
	}

	public void setUh_id(Integer uh_id) {
		this.uh_id = uh_id;
	} 	
}
