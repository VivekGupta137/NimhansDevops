package com.pe.nimhans.service;

import org.springframework.stereotype.Service;

import com.pe.nimhans.entity.ClinicalDetails;
import com.pe.nimhans.entity.DemographicDetails;
import com.pe.nimhans.entity.NeurologicalDetails;
import com.pe.nimhans.entity.PhysicalDetails;

@Service
public interface InformationService {
	public ClinicalDetails save(ClinicalDetails theClinicalDetails);
	public DemographicDetails save(DemographicDetails theDemographicDetails);
	public NeurologicalDetails save(NeurologicalDetails theNeurologicalDetails);
	public PhysicalDetails save(PhysicalDetails thePhysicalDetails);
	
}
