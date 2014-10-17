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
	public void testNextLong()
		throws Exception {
		long result = RandomUtils.nextLong();
	}
	
	@Test
	public void testInsertContractors(){
		String[] name={" INC"," LLC", " PLC", " CORP"};
		Integer[] zip={92714,92715, 92718, 92720};
		Double[] myLatArray = {33.68764d,33.650884d,33.658179d,33.707495d};

		Double[] myLongArray = {-117.798928,-117.821251,-117.711476,-117.765533};

		String[] bname={"ELECTRICALS","PLUMBERS", "JANITORIAL SERVICES", "WELDING SERVICES","DRILLING SERVICES","PAINTING SERVICES","MASONRY SERVICES"};
		
		String[] trades={"ELECTRICIAN","PLUMBING", "JANITORIAL", "WELDING","DRILLING","PAINTING","MASONRY"};
		for(int i=0;i<10;i++){
			String trade=trades[RandomUtils.nextInt(7)];
			double lat=myLatArray[RandomUtils.nextInt(4)];
			double lon=myLongArray[RandomUtils.nextInt(4)];
		insertContractor("MOE's "+trade +name[RandomUtils.nextInt(4)], trade,zip[RandomUtils.nextInt(4)],i, lat,lon );
		trade=trades[RandomUtils.nextInt(7)];
		lat=myLatArray[RandomUtils.nextInt(4)];
		lon=myLongArray[RandomUtils.nextInt(4)];
		insertContractor("JIM's " +trade +name[RandomUtils.nextInt(4)],  trade,zip[RandomUtils.nextInt(4)],i, lat,lon );
		trade=trades[RandomUtils.nextInt(7)];
		lat=myLatArray[RandomUtils.nextInt(4)];
		lon=myLongArray[RandomUtils.nextInt(4)];
		insertContractor("TIM's "+trade +name[RandomUtils.nextInt(4)],  trade,zip[RandomUtils.nextInt(4)],i, lat,lon );
		trade=trades[RandomUtils.nextInt(7)];
		lat=myLatArray[RandomUtils.nextInt(4)];
		lon=myLongArray[RandomUtils.nextInt(4)];
		insertContractor("MIKE's "+trade +name[RandomUtils.nextInt(4)],  trade,zip[RandomUtils.nextInt(4)],i, lat,lon );
		trade=trades[RandomUtils.nextInt(7)];
		lat=myLatArray[RandomUtils.nextInt(4)];
		lon=myLongArray[RandomUtils.nextInt(4)];
		insertContractor("TOM's "+trade +name[RandomUtils.nextInt(4)],  trade,zip[RandomUtils.nextInt(4)],i, lat,lon );
		trade=trades[RandomUtils.nextInt(7)];
		lat=myLatArray[RandomUtils.nextInt(4)];
		lon=myLongArray[RandomUtils.nextInt(4)];
		insertContractor("JONAS'S "+trade +name[RandomUtils.nextInt(4)],  trade,zip[RandomUtils.nextInt(4)],i, lat,lon );
		trade=trades[RandomUtils.nextInt(7)];
		lat=myLatArray[RandomUtils.nextInt(4)];
		lon=myLongArray[RandomUtils.nextInt(4)];
		insertContractor("MAY'S "+trade +name[RandomUtils.nextInt(4)],  trade,zip[RandomUtils.nextInt(4)],i, lat,lon );
		trade=trades[RandomUtils.nextInt(7)];
		lat=myLatArray[RandomUtils.nextInt(4)];
		lon=myLongArray[RandomUtils.nextInt(4)];
		insertContractor("MYRA'S "+trade +name[RandomUtils.nextInt(4)],  trade,zip[RandomUtils.nextInt(4)],i, lat,lon );
		trade=trades[RandomUtils.nextInt(7)];
		lat=myLatArray[RandomUtils.nextInt(4)];
		lon=myLongArray[RandomUtils.nextInt(4)];
		insertContractor("TAMMY'S "+trade +name[RandomUtils.nextInt(4)],  trade,zip[RandomUtils.nextInt(4)],i, lat,lon );
		trade=trades[RandomUtils.nextInt(7)];
		lat=myLatArray[RandomUtils.nextInt(4)];
		lon=myLongArray[RandomUtils.nextInt(4)];
		insertContractor("TOMMY'S "+trade +name[RandomUtils.nextInt(4)],  trade,zip[RandomUtils.nextInt(4)],i, lat,lon );		
		}
		
	}

	private void insertContractor(String name, String trade, Integer zip, int i, double lat, double lon ){
		Contractor m=new Contractor();
		m.setBusinessName(name);
		m.setLatitute(lat);
		m.setLogitute(lon);
		m.setAddress(RandomUtils.nextInt()+"123 Test drive");
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
		review2.setComment(UUID.randomUUID()+" - TEST COMMENT- Contractor did a lousy job ******.  Showed up late and left behind a mess.");
		review2.setDate(new Date());
		review2.setRating(1);

		Contractor.Review review3=m.new Review();

		m.setTrades(type);
		review3.setAuthor("Sam");
		review3.setComment(UUID.randomUUID()+" - TEST COMMENT- Contractor is OK.  Called him to fix lights and showed up 15 muinutes late");
		review3.setDate(new Date());
		review3.setRating(3);
		Contractor.Review review4=m.new Review();

		m.setTrades(type);
		review4.setAuthor("Tim");
		review4.setComment(UUID.randomUUID()+" - TEST COMMENT- Contractor is OK.  Does a decent job.");
		review4.setDate(new Date());
		review4.setRating(2);		
		Contractor.Review review5=m.new Review();

		m.setTrades(type);
		review5.setAuthor("Tomas");
		review5.setComment(UUID.randomUUID()+" - TEST COMMENT- Contractor is good.  Does a very thorough job.");
		review5.setDate(new Date());
		review5.setRating(4);
		
		List reviews=new ArrayList();
		reviews.add(review);
		reviews.add(review2);
		reviews.add(review3);	
		reviews.add(review4);
		reviews.add(review5);
		m.setReviews(reviews);

		dao.save(m);
	}

	@Test
	public void testRandom(){
		for(int i=0;i<100;i++){
		System.out.println("6 rand :"+RandomUtils.nextInt(7));
		System.out.println("4 rand : "+RandomUtils.nextInt(4));
		}
	}
}
