package com.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.model.LocationMap;

@Service
public interface ILocationMapService {

	public  abstract void insertLocation(LocationMap  locationMap);
	public abstract Collection<Object> getNearestLocation(double log,double lat, double nearby);
}
