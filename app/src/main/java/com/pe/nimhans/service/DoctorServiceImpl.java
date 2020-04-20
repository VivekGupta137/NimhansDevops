package com.pe.nimhans.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pe.nimhans.dao.DoctorRepository;
import com.pe.nimhans.entity.Doctor;
import com.pe.nimhans.entity.Encounter;

@Repository
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	DoctorRepository repo;
	@Autowired
	EntityManager em;
	
	@Override
	public List<Doctor> findAll() {
		return repo.findAll();
	}

	@Override
	public Doctor findById(int id) {
		if(!repo.findById(id).isPresent())	return null;
		return repo.findById(id).get();
	}

	@Override
	public void save(Doctor theDoctor) {
		repo.save(theDoctor);
	}

	@Override
	public void deleteById(int id) {
		repo.deleteById(id);
	}

	@Override
	public int findIdByName(String username) {
		Query query = em.createQuery("from Doctor where dname=:username");
		query.setParameter("username", username);
		List<Doctor> doctors = query.getResultList();
		if(doctors.size() == 0) return -1;
		
		return doctors.get(0).getEmp_id();
	}

	@Override
	public List<Encounter> getAllEncounters(int id) {
		Optional<Doctor> result = repo.findById(id);
		if(!result.isPresent()) return null;
		return result.get().getEncounters();
	}

}
