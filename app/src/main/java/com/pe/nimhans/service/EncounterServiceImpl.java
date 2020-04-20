package com.pe.nimhans.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pe.nimhans.dao.EncounterRepository;
import com.pe.nimhans.entity.Encounter;


@Repository
public class EncounterServiceImpl implements EncounterService {

	@Autowired
	EncounterRepository repo;
	
	@Override
	public List<Encounter> findAll() {
		return repo.findAll();
	}

	@Override
	public Encounter findById(int eid) {
		if(!repo.findById(eid).isPresent())	return null;
		return repo.findById(eid).get();
	}

	@Override
	public void save(Encounter theEncounter) {
		repo.save(theEncounter);
	}

	@Override
	public void deleteById(int eid) {
		repo.deleteById(eid);
	}

}
