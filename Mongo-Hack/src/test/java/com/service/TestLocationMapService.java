package com.service;

import java.util.Arrays;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dao.IReviewsRepositoryDao;
import com.model.Contractor;


public class TestLocationMapService extends BaseServiceHarness {

	@Autowired
	IContractorService service;
	
	@Autowired
	IReviewsRepositoryDao dao;
	@Test
	public void testInsertLocation() {
		Contractor m=new Contractor();
		m.setBusinessName("ELEC TEK");
		m.setLatitute(103.7866d);
		m.setLogitute(1.43);
		m.setName("Test Business Name");
		Contractor.Review review=m.new Review();
		
		List<String> type=new ArrayList<String>();
		type.add("ELECTRICIAN");
		m.setTrades(type);
		review.setAuthor("TEST");
		review.setComment("TEST COMMENT- Contractor is great");
		review.setDate(new Date());
		review.setRating(5);

		m.setReviews(Arrays.asList(review));
		dao.save(m);
		
		List<Contractor> c=service.findAllContractors();
		/*
		for(Contractor cc:c){
			log.debug("Contractor : {}",cc);
		}
		
		 c=  service.searchContractorByCriteria(Arrays.asList("ELECTRICIAN"),null);
		
		for(Contractor cc:c){
			log.debug("Contractor finder : {}",cc);
		}
*/		 c=  service.searchContractorByCriteria(Arrays.asList("PLUMBER"),5);	
			
			for(Contractor cc:c){
				log.debug("Contractor by rating : {}",cc);
			}
		System.out.println(service.getNearestLocation(142.0, 134.0, 10));
	}

}
