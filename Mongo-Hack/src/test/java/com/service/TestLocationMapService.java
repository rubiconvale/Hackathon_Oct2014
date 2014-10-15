package com.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang.math.RandomUtils;
import org.hibernate.id.GUIDGenerator;
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
		String[] name={" INC"," LLC", " PLC", " CORP"};
		Integer[] zip={92714,92715, 92718, 92720};
		String[] trades={"ELECTRICIAN","PLUMBING", "JANITORIAL", "WELDING","FORKLIFT","AIRCRAFT MAINTENANCE","PAINTING"};
		for(int i=0;i<10;i++){
		insertContractor("MIKE's ELECTRICALS" +name[RandomUtils.nextInt(4)], trades[RandomUtils.nextInt(6)],zip[RandomUtils.nextInt(4)],i);
		insertContractor("JIM's PLUMBING" +name[RandomUtils.nextInt(4)], trades[RandomUtils.nextInt(6)],zip[RandomUtils.nextInt(4)],i);
		insertContractor("TIM's SEWAGE CLEANING" +name[RandomUtils.nextInt(4)], trades[RandomUtils.nextInt(6)],zip[RandomUtils.nextInt(4)],i);
		insertContractor("MIKE's WELDING" +name[RandomUtils.nextInt(4)], trades[RandomUtils.nextInt(6)],zip[RandomUtils.nextInt(4)],i);
		insertContractor("TOM's FORKLIFT" +name[RandomUtils.nextInt(4)], trades[RandomUtils.nextInt(6)],zip[RandomUtils.nextInt(4)],i);
		insertContractor("MARK'S MECHANICS" +name[RandomUtils.nextInt(4)], trades[RandomUtils.nextInt(6)],zip[RandomUtils.nextInt(4)],i);
		insertContractor("JOHN'S PAINTING" +name[RandomUtils.nextInt(4)], trades[RandomUtils.nextInt(6)],zip[RandomUtils.nextInt(4)],i);
		}
		
	}

	private void insertContractor(String name, String trade, Integer zip, int i ){
		Contractor m=new Contractor();
		m.setBusinessName(name);
		m.setLatitute(103.7866d);
		m.setLogitute(1.43);
		m.setAddress("123 Test drive");
		m.setContactName("Jim Jones");
		m.setName(name);
		m.setPhoneNo(new Long(9494387500l+i).toString());
		m.setZipCode(zip);
		Contractor.Review review=m.new Review();
		
		List<String> type=new ArrayList<String>();
		type.add(trade);
		m.setTrades(type);
		review.setAuthor("Mike");
		review.setComment(UUID.randomUUID()+" - TEST COMMENT- Contractor is great");
		review.setDate(new Date());
		review.setRating(5);


		Contractor.Review review2=m.new Review();

		m.setTrades(type);
		review2.setAuthor("Jonas");
		review2.setComment(UUID.randomUUID()+" - TEST COMMENT- Contractor is not great");
		review2.setDate(new Date());
		review2.setRating(2);

		Contractor.Review review3=m.new Review();

		m.setTrades(type);
		review3.setAuthor("Sam");
		review3.setComment(UUID.randomUUID()+" - TEST COMMENT- Contractor is OK.  Called him to fix lights and showed up 15 muinutes late");
		review3.setDate(new Date());
		review3.setRating(3);
		Contractor.Review review4=m.new Review();

		m.setTrades(type);
		review4.setAuthor("Tim");
		review4.setComment(UUID.randomUUID()+" - TEST COMMENT- Contractor is OK.  Does a decent job Called him to fix lights and showed up 15 muinutes late");
		review4.setDate(new Date());
		review4.setRating(4);		
		List reviews=new ArrayList();
		reviews.add(review);
		reviews.add(review2);
		reviews.add(review3);	
		reviews.add(review4);
		m.setReviews(reviews);

		dao.save(m);
	}

}
