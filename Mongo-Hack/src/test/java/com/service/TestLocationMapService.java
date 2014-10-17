package com.service;

import com.dao.IReviewsRepositoryDao;
import com.model.Contractor;
import com.model.ContractorDTO;
import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;


public class TestLocationMapService extends BaseServiceHarness {

	@Autowired
	IContractorService service;

	@Autowired
	IReviewsRepositoryDao dao;

	private String[] trades = {"ELECTRICIAN", "PLUMBING", "JANITORIAL", "WELDING", "DRILLING", "PAINTING", "MASONRY"};

	@Test
	public void testSearchLocation() {

		List<ContractorDTO> c = service.searchContractorByCriteria(Arrays.asList("ELECTRICIAN"), 4, 92714);

		for (ContractorDTO cc : c) {
			log.debug("Contractor by rating : {}", cc.getReviews().toArray());
			log.debug("Contractor  Average rating : {}", cc.getAvgRating());
		}
		//System.out.println(service.getNearestLocation(142.0, 134.0, 10));
	}

	@Test
	public void testNextLong()
			throws Exception {
		long result = RandomUtils.nextLong();
	}

	@Test
	public void testInsertContractors() {
		String[] name = {" INC", " LLC", " PLC", " CORP"};
		Integer[] zip = {92714, 92715, 92718, 92720};
		Double[] myLatArray = {33.68764d, 33.650884d, 33.658179d, 33.707495d};

		Double[] myLongArray = {-117.798928, -117.821251, -117.711476, -117.765533};

		String[] bname = {"ELECTRICALS", "PLUMBERS", "JANITORIAL SERVICES", "WELDING SERVICES", "DRILLING SERVICES", "PAINTING SERVICES", "MASONRY SERVICES"};

		for (int i = 0; i < 10; i++) {
			String trade = trades[RandomUtils.nextInt(7)];
			double lat = myLatArray[RandomUtils.nextInt(4)];
			double lon = myLongArray[RandomUtils.nextInt(4)];
			insertContractor("MOE's " + trade + name[RandomUtils.nextInt(4)], trade, zip[RandomUtils.nextInt(4)], i, lat, lon);
			trade = trades[RandomUtils.nextInt(7)];
			lat = myLatArray[RandomUtils.nextInt(4)];
			lon = myLongArray[RandomUtils.nextInt(4)];
			insertContractor("JIM's " + trade + name[RandomUtils.nextInt(4)], trade, zip[RandomUtils.nextInt(4)], i, lat, lon);
			trade = trades[RandomUtils.nextInt(7)];
			lat = myLatArray[RandomUtils.nextInt(4)];
			lon = myLongArray[RandomUtils.nextInt(4)];
			insertContractor("TIM's " + trade + name[RandomUtils.nextInt(4)], trade, zip[RandomUtils.nextInt(4)], i, lat, lon);
			trade = trades[RandomUtils.nextInt(7)];
			lat = myLatArray[RandomUtils.nextInt(4)];
			lon = myLongArray[RandomUtils.nextInt(4)];
			insertContractor("MIKE's " + trade + name[RandomUtils.nextInt(4)], trade, zip[RandomUtils.nextInt(4)], i, lat, lon);
			trade = trades[RandomUtils.nextInt(7)];
			lat = myLatArray[RandomUtils.nextInt(4)];
			lon = myLongArray[RandomUtils.nextInt(4)];
			insertContractor("TOM's " + trade + name[RandomUtils.nextInt(4)], trade, zip[RandomUtils.nextInt(4)], i, lat, lon);
			trade = trades[RandomUtils.nextInt(7)];
			lat = myLatArray[RandomUtils.nextInt(4)];
			lon = myLongArray[RandomUtils.nextInt(4)];
			insertContractor("JONAS'S " + trade + name[RandomUtils.nextInt(4)], trade, zip[RandomUtils.nextInt(4)], i, lat, lon);
			trade = trades[RandomUtils.nextInt(7)];
			lat = myLatArray[RandomUtils.nextInt(4)];
			lon = myLongArray[RandomUtils.nextInt(4)];
			insertContractor("MAY'S " + trade + name[RandomUtils.nextInt(4)], trade, zip[RandomUtils.nextInt(4)], i, lat, lon);
			trade = trades[RandomUtils.nextInt(7)];
			lat = myLatArray[RandomUtils.nextInt(4)];
			lon = myLongArray[RandomUtils.nextInt(4)];
			insertContractor("MYRA'S " + trade + name[RandomUtils.nextInt(4)], trade, zip[RandomUtils.nextInt(4)], i, lat, lon);
			trade = trades[RandomUtils.nextInt(7)];
			lat = myLatArray[RandomUtils.nextInt(4)];
			lon = myLongArray[RandomUtils.nextInt(4)];
			insertContractor("TAMMY'S " + trade + name[RandomUtils.nextInt(4)], trade, zip[RandomUtils.nextInt(4)], i, lat, lon);
			trade = trades[RandomUtils.nextInt(7)];
			lat = myLatArray[RandomUtils.nextInt(4)];
			lon = myLongArray[RandomUtils.nextInt(4)];
			insertContractor("TOMMY'S " + trade + name[RandomUtils.nextInt(4)], trade, zip[RandomUtils.nextInt(4)], i, lat, lon);
		}

	}

	private void insertContractor(String name, String trade, Integer zip, int i, double lat, double lon) {
		Contractor m = new Contractor();
		m.setBusinessName(name);
		m.setLatitute(lat);
		m.setLogitute(lon);
		m.setAddress(RandomUtils.nextInt() + "123 Test drive");
		m.setContactName("Jim Jones");
		m.setName(name);
		m.setPhoneNo(new Long(9494387500l + i).toString());
		m.setZipCode(zip);
		Contractor.Review review = m.new Review();

		List<String> type = new ArrayList<String>();
		type.add(trade);
		m.setTrades(type);
		review.setAuthor("Mike");
		review.setComment(UUID.randomUUID() + " - TEST COMMENT- Contractor is great");
		review.setDate(new Date());
		review.setRating(5);


		Contractor.Review review2 = m.new Review();

		m.setTrades(type);
		review2.setAuthor("Jonas");
		review2.setComment(UUID.randomUUID() + " - TEST COMMENT- Contractor did a lousy job ******.  Showed up late and left behind a mess.");
		review2.setDate(new Date());
		review2.setRating(1);

		Contractor.Review review3 = m.new Review();

		m.setTrades(type);
		review3.setAuthor("Sam");
		review3.setComment(UUID.randomUUID() + " - TEST COMMENT- Contractor is OK.  Called him to fix lights and showed up 15 muinutes late");
		review3.setDate(new Date());
		review3.setRating(3);
		Contractor.Review review4 = m.new Review();

		m.setTrades(type);
		review4.setAuthor("Tim");
		review4.setComment(UUID.randomUUID() + " - TEST COMMENT- Contractor is OK.  Does a decent job.");
		review4.setDate(new Date());
		review4.setRating(2);
		Contractor.Review review5 = m.new Review();

		m.setTrades(type);
		review5.setAuthor("Tomas");
		review5.setComment(UUID.randomUUID() + " - TEST COMMENT- Contractor is good.  Does a very thorough job.");
		review5.setDate(new Date());
		review5.setRating(4);

		List reviews = new ArrayList();
		reviews.add(review);
		reviews.add(review2);
		reviews.add(review3);
		reviews.add(review4);
		reviews.add(review5);
		m.setReviews(reviews);

		dao.save(m);
	}

	@Test
	public void testRandom() {
		for (int i = 0; i < 100; i++) {
			System.out.println("6 rand :" + RandomUtils.nextInt(7));
			System.out.println("4 rand : " + RandomUtils.nextInt(4));
		}
	}

	@Test
	public void generateData() {
		insertContractor("PTS Staffing Solutions", "9960 Research Dr. Suite 200", trades[0], 92618, 33.629818, -117.728500);
		insertContractor("Air Quality Engineering, Inc.", "1618 French Street", trades[1], 92701, 33.759567, -117.864189);
		insertContractor("INOVx Solutions", "100 Pacifica, Suite 300", trades[2], 92618, 33.659458, -117.754936);
		insertContractor("NEWTECH Resources", "2525 Main Street, Suite 400", trades[3], 92614, 33.683067, -117.844543);
		insertContractor("Horiba Instruments Inc", "34 Busen", trades[4], 92618, 33.642406, -117.741028);
		insertContractor("Technology Resource Center, Inc.", "2101 E 4th Street, STE 130A", trades[5], 92705, 33.748970, -117.837082);
		insertContractor("Test Inc.", "11021 Hunting Horn Dr.", trades[6], 92705, 33.765785, -117.781212);
		insertContractor("Cemtek Environmental", "3041 S. Orange Avenue", trades[0], 92707, 33.716034, -117.865295);
		insertContractor("California Barricade, Inc.", "1550 East St. Gertrude Place", trades[1], 92705, 33.719219, -117.849220);
		insertContractor("J. C. Palomar Construction, Inc.", "2627 S. Main Street", trades[2], 92707, 33.710285, -117.867744);
		insertContractor("EnviroSupply & Service, Inc.", "1791 Kaiser Avenue", trades[3], 92614, 33.693832, -117.848335);
		insertContractor("Resources Connection, LLC", "1701 Armstrong Avnue", trades[4], 92614, 33.694485, -117.845215);
		insertContractor("Innovative Construction Solutions", "4011 W. Chandler Avenue", trades[5], 92704, 33.710083, -117.922676);
		insertContractor("Expertech Consulting Inc.", "12 Lyra", trades[6], 92603 - 5712, 33.642452, -117.809746);
		insertContractor("Operation Technology, Inc.", "17 Goodyear, Suite 100", trades[0], 92618, 33.651356, -117.709595);
		insertContractor("Ben's Asphalt Inc.", "2200 South Yale Street", trades[1], 92704, 33.717857, -117.917000);
		insertContractor("JAG Consulting Group, Inc.", "3340 S. Crawford Glen", trades[2], 92704, 33.702263, -117.895927);
		insertContractor("Pickett Painting, Inc.", "1805 E Carnegie Ave.", trades[3], 92705, 33.711277, -117.844551);
		insertContractor("Techref Inc.", "10005 Muirlands Ste N", trades[4], 92618, 33.810619, -117.887802);
		insertContractor("InsulTech Services Corp", "3530 W. Garry Avenue", trades[5], 92704, 33.705135, -117.916832);
		insertContractor("Isograph, Inc.", "2020 Main", trades[6], 92614, 33.683636, -117.853401);
		insertContractor("Mission Critical Information Systems Inc.", "505 N. Tustin Ave Suite 222", trades[0], 92705, 33.749504, -117.833237);
		insertContractor("Cellco Partnership d/b/a Verizon Wireless", "15505 Sand Canyon Avenue", trades[1], 92618, 33.668797, -117.768967);
		insertContractor("JIMNI SYSTEMS, Inc.", "11161 Jeffery Road", trades[2], 92602, 33.716381, -117.741669);
		insertContractor("The Whiting-Turner Contracting Company", "250 Commerce, Suite #150", trades[3], 92602, 33.717010, -117.788986);
		insertContractor("Trace3", "15326 Alton Parkway", trades[4], 92618, 33.648857, -117.733650);
		insertContractor("K2 General Contractors, Inc.", "17701 Cowan Suite 160", trades[5], 92614, 33.695435, -117.857697);
		insertContractor("Centergistic Solutions, Inc.", "2112 Business Center Drive", trades[6], 91773, 33.680809, -117.854355);
		insertContractor("Hardy & Harper, Inc.", "1312 E. Warner Ave.", trades[0], 92705, 33.715012, -117.853874);
		insertContractor("Candlewood Suites OC Airport- Irvine West JWASA", "2600 South Red Hill Avenue", trades[1], 92705, 33.706581, -117.843643);
		insertContractor("Candlewood Suites Orange Cty/Irvine Spectrum LAXSD", "16150 Sand Canyon Avenue", trades[3], 92618, 33.662125, -117.769844);
		insertContractor("Mission Landscape Companies", "16672 Millikan Ave.", trades[3], 92606, 33.693855, -117.830917);
		insertContractor("Spectrum Mechanical, Inc.", "9760 Research Drive, Unit DD", trades[4], 92618, 33.632908, -117.729828);
		insertContractor("Southern California Grading, Inc.", "16291 Construction Circle East", trades[5], 92606, 33.694557, -117.821632);
		insertContractor("Epsilon Technologies International, LLC", "15540 Rockfield Blvd C110", trades[6], 92618, 33.639595, -117.722786);
		insertContractor("Straightline Mechanical, Inc", "1051 E. 6th Street", trades[1], 92701, 33.750034, -117.854706);
		insertContractor("DESTRIER INC.", "PO Box 60875", trades[2], 92602, 33.751488, -117.754929);
		insertContractor("STATEWIDE TRAFFIC SAFETY & SIGNS", "PO BOX 5299", trades[3], 92616, 33.647900, -117.834702);
		insertContractor("AE Suncor Test", "123 Main", trades[4], 91222, 33.742104, -117.823372);
		insertContractor("Express Chipping, Inc. East Coast", "1323 E. St. Gertrude Pl Suite B", trades[5], 92705, 33.720791, -117.852715);
		insertContractor("pivox corporation", "7595 irvine center drive, suite 150", trades[6], 92618, 33.661457, -117.751434);
		insertContractor("Process Cellular Inc.", "3020 W. Harvard St.", trades[0], 92704, 33.719742, -117.909950);
		insertContractor("The W Corporation DBA Vantage Company", "17785 Sky Park Circle #C", trades[1], 92614, 33.690067, -117.854095);
		insertContractor("Terra Pacific Group", "13900 Alton Parkway, Suite 122", trades[2], 92618, 33.661297, -117.708778);
		insertContractor("Velocitel, Inc. ", "2415 Campus Dr., Suite 200", trades[3], 92614, 33.669617, -117.858810);
		insertContractor("Vinculums Services, Inc", "10 Pasteur, Ste 100", trades[4], 92618, 33.654907, -117.765266);
	}

	private void insertContractor(String name, String address, String trade, Integer zip, double lat, double lon) {
		Contractor m = new Contractor();
		m.setBusinessName(name);
		m.setLatitute(lat);
		m.setLogitute(lon);
		m.setAddress(address);
		m.setContactName("Jim Jones");
		m.setName(name);
		m.setPhoneNo("949-555-5555");
		m.setZipCode(zip);
		Contractor.Review review = m.new Review();

		List<String> type = new ArrayList<String>();
		type.add(trade);
		m.setTrades(type);
		review.setAuthor("Mike");
		review.setComment("Contractor is great");
		review.setDate(new Date());
		review.setRating(RandomUtils.nextInt(5) + 1);

		Contractor.Review review2 = m.new Review();

		m.setTrades(type);
		review2.setAuthor("Jane");
		review2.setComment("Worked with the contractor on a small project");
		review2.setDate(new Date());
		review2.setRating(RandomUtils.nextInt(4) + 1);

		Contractor.Review review3 = m.new Review();

		m.setTrades(type);
		review3.setAuthor("Sam");
		review3.setComment("Contractor is OK.  Called him to fix lights and showed up 15 minutes late");
		review3.setDate(new Date());
		review3.setRating(RandomUtils.nextInt(4) + 1);
		Contractor.Review review4 = m.new Review();

		m.setTrades(type);
		review4.setAuthor("Tim");
		review4.setComment("Contractor is OK.  Does a decent job Called him to fix lights and showed up 15 muinutes late");
		review4.setDate(new Date());
		review4.setRating(RandomUtils.nextInt(3) + 1);

		Contractor.Review review5 = m.new Review();
		m.setTrades(type);
		review5.setAuthor("Jill");
		review5.setComment("Worked with contractor on a large job");
		review5.setDate(new Date());
		review5.setRating(RandomUtils.nextInt(3) + 1);

		List reviews = new ArrayList();
		reviews.add(review);
		reviews.add(review2);
		reviews.add(review3);
		reviews.add(review4);
		reviews.add(review5);
		m.setReviews(reviews);

		dao.save(m);
	}
}
