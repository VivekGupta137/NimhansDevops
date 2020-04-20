package com.pe.nimhans.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pe.nimhans.entity.Encounter;

public interface EncounterRepository extends JpaRepository<Encounter, Integer> {

}
