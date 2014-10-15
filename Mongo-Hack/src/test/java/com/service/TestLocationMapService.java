package com.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dao.IReviewsRepositoryDao;
import com.model.Contractor;
import com.model.ContractorDTO;


public class TestLocationMapService extends BaseServiceHarness {

	@Autowired
	IContractorService service;
	
	@Autowired
	IReviewsRepositoryDao dao;
	@Test
	public void testSearchLocation() {

		List<ContractorDTO> c=  service.searchContractorByCriteria(Arrays.asList("ELECTRICIAN"),4,92714);	
			
			for(ContractorDTO cc:c){
				log.debug("Contractor by rating : {}",cc.getReviews().toArray());
				log.debug("Contractor  Average rating : {}",cc.getAvgRating());
			}
		//System.out.println(service.getNearestLocation(142.0, 134.0, 10));
	}
	
	@Test
	public void testInsertContractors(){
		String[] name={" HA"," MA", " YA", " RA"};
		for(int i=0;i<10;i++){
		insertContractor("MIKE's ELECTRICALS" +name[RandomUtils.nextInt(3)], "ELECTRICIAN",92714);
		insertContractor("JIM's PLUMBING" +name[RandomUtils.nextInt(3)], "PLUMBING",92715);
		insertContractor("TIM's SEWAGE CLEANING" +name[RandomUtils.nextInt(3)], "JANITORIAL",92718);
		insertContractor("MIKE's WELDING" +name[RandomUtils.nextInt(3)], "WELDING",92720);
		insertContractor("TOM's FORKLIFT" +name[RandomUtils.nextInt(3)], "FORKLIFT",92714);
		insertContractor("MARK'S MECHANICS" +name[RandomUtils.nextInt(3)], "AIRCCRAFT MAINTENANCE",92714);
		insertContractor("JOHN'S PAINING" +name[RandomUtils.nextInt(3)], "PAINTING",92714);
		}
		
	}

	private void insertContractor(String name, String trade, Integer zip ){
		Contractor m=new Contractor();
		m.setBusinessName(name);
		m.setLatitute(103.7866d);
		m.setLogitute(1.43);
		m.setAddress("123 Test drive");
		m.setContactName("Jim Jones");
		m.setName(name);
		m.setPhoneNo("949 300 7500");
		m.setZipCode(zip);
		Contractor.Review review=m.new Review();
		
		List<String> type=new ArrayList<String>();
		type.add(trade);
		m.setTrades(type);
		review.setAuthor("Mike");
		review.setComment("TEST COMMENT- Contractor is great");
		review.setDate(new Date());
		review.setRating(5);


		Contractor.Review review2=m.new Review();

		m.setTrades(type);
		review2.setAuthor("Jonas");
		review2.setComment("TEST COMMENT- Contractor is not great");
		review2.setDate(new Date());
		review2.setRating(2);
		review.setAuthor("Mike");
		review.setComment("TEST COMMENT- Contractor is great");
		review.setDate(new Date());
		review.setRating(5);


		Contractor.Review review3=m.new Review();

		m.setTrades(type);
		review2.setAuthor("Sam");
		review2.setComment("TEST COMMENT- Contractor is OK.  Called him to fix lights and showed up 15 muinutes late");
		review2.setDate(new Date());
		review2.setRating(3);
		
		List reviews=new ArrayList();
		reviews.add(review);
		reviews.add(review2);
		reviews.add(review3);		
		m.setReviews(reviews);

		dao.save(m);
	}

}
