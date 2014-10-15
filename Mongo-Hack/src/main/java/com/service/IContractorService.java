package com.service;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Contractor;
import com.model.ContractorDTO;

@Service
public interface IContractorService {

	public  abstract void insert(Contractor  contractor);
	public  abstract void update(Contractor  contractor);
	public  abstract ContractorDTO find(Contractor  contractor);
	public  abstract void delete(Contractor  contractor);
	public  abstract List<ContractorDTO> findAllContractors() ;
	public abstract List<ContractorDTO> searchContractorByCriteria(List<String> trades, Integer rating, Integer zipCode);
	public abstract Collection<Object> getNearestLocation(double log,double lat, double nearby);
}
