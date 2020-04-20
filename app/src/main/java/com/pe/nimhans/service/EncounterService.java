package com.pe.nimhans.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pe.nimhans.entity.Encounter;

@Service
public interface EncounterService {
	public List<Encounter> findAll(); // lists all the encounters
	public Encounter findById(int eid);
	public void save(Encounter theEncounter);
	public void deleteById(int id);
}
