package com.pe.nimhans.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pe.nimhans.dao.DemoRepository;
import com.pe.nimhans.entity.Demo;
import com.pe.nimhans.entity.Ehrid_uhid_mapper;
import com.pe.nimhans.entity.Encounter;
import com.pe.nimhans.entity.Patient;

@Repository
public class UhidServiceImpl implements UhidService{
	@Autowired
	EntityManager em;
	@Autowired
	PatientService patient;
	@Autowired
	DemoRepository demo;	
	
	@Override
	@Transactional
	public void save(Ehrid_uhid_mapper map) {
		System.out.println("\ninside save:\n");
		em.persist(map);
	}
	
	@Override
	@Transactional
	public List<Encounter> getEncounterByUhrid(Integer uhr_id) {		
		Query query = em.createQuery("from Demo d where d.uh_id=:uhr_id");
		query.setParameter("uhr_id",uhr_id);		
		try {
			Demo result = (Demo)query.getSingleResult();
			return result.getTheMapper().getPatient().getEncounters();
		}
		catch(Exception e) {
			return null;
		}
	}

	@Override
	@Transactional
	public Patient getPatientByUhrid(Integer uhr_id) {
		Query query = em.createQuery("from Demo d where d.uh_id=:uhr_id");
		query.setParameter("uhr_id",uhr_id);
		try {
			Demo result = (Demo)query.getSingleResult();
			return result.getTheMapper().getPatient();
		}
		catch(Exception e) {
			return null;
		}
	}
}
