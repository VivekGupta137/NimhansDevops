package com.pe.nimhans.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pe.nimhans.entity.Ehrid_uhid_mapper;
import com.pe.nimhans.entity.Encounter;
import com.pe.nimhans.entity.Patient;

@Service
public interface UhidService {
	public void save(Ehrid_uhid_mapper map);
	public List<Encounter> getEncounterByUhrid(Integer uhr_id);
	public Patient getPatientByUhrid(Integer uhr_id);
}
