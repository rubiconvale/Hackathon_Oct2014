package com.service;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Contractor;

@Service
public interface IContractorService {

	public  abstract void insert(Contractor  contractor);
	public  abstract void update(Contractor  contractor);
	public  abstract void find(Contractor  contractor);
	public  abstract void delete(Contractor  contractor);
	public  abstract List<Contractor> findAllContractors() ;
	public abstract List<Contractor> searchContractorByCriteria(List<String> trades, Integer rating);
	public abstract Collection<Object> getNearestLocation(double log,double lat, double nearby);
}
