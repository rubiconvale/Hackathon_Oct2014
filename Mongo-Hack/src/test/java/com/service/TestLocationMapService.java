package com.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dao.IReviewsRepositoryDao;
import com.model.LocationMap;


public class TestLocationMapService extends BaseServiceHarness {

	@Autowired
	ILocationMapService service;
	
	@Autowired
	IReviewsRepositoryDao dao;
	@Test
	public void testInsertLocation() {
		LocationMap m=new LocationMap();
		m.setBusinessName("TEST");
		m.setLatitute(103.7866d);
		m.setLogitute(1.43);
		m.setName("Test Business Name");
		
		List<String> type=new ArrayList<String>(m.getType());
		type.add("PLUMBER");
		m.setType(type);
		dao.save(m);
		
		System.out.println(service.getNearestLocation(142.0, 134.0, 10));
	}

}
