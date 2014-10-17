package com.service.impl;

import com.dao.IReviewsRepositoryDao;
import com.model.*;
import com.model.Contractor.Review;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.CommandResult;
import com.mongodb.DBObject;
import com.service.IContractorService;
import org.apache.commons.collections.CollectionUtils;
import org.crsh.console.jline.internal.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


@Service("locationMapService")
public class ContractorService implements IContractorService {

	@Autowired
	IReviewsRepositoryDao reviewsDao;

	@Autowired

	MongoTemplate mongoTemplate;

	public Collection<Object> getNearestLocation(double log, double lat, double nearby) {

		//Circle circle = new Circle(log, lat, nearby);

		DBObject cmd = null;
		BasicDBObject query = new BasicDBObject();
		query.put("_class", "edu.samples.mvc.basic.LocationMap");
		BasicDBObjectBuilder documentBuilder = BasicDBObjectBuilder.start().add("geoNear", "map").add("near", new
				double[]{lat, log}).add("num", 10).add("maxDistance", 10).add("distanceMultiplier", (6371 * Math.PI / 180.0d)).add("query", query);
		cmd = documentBuilder.get();
		CommandResult cr = mongoTemplate.executeCommand(cmd);
		return cr.values();
	}

	public void insert(Contractor contractor) {
		reviewsDao.save(contractor);

	}

	public void update(Contractor contractor) {

	}

	public void updateReview(ReviewDTO reviewDTO) {
		Contractor contractor = reviewsDao.findOne(reviewDTO.getContractorId());
		Contractor.Review review = contractor.new Review();
		review.setAuthor(reviewDTO.getAuthor());
		review.setComment(reviewDTO.getComment());
		review.setRating(reviewDTO.getRating());
		review.setDate(new Date());
		contractor.getReviews().add(review);

		reviewsDao.save(contractor);
	}

	public List<ContractorDTO> findAllContractors() {

		return mongoTemplate.findAll(ContractorDTO.class);
	}

	public void delete(Contractor contractor) {

	}


	public List<ContractorDTO> searchContractorByCriteria(List<String> trades, Integer rating, Integer zipCode) {

		String city = null;
		String state = null;
		List<ContractorDTO> finalList = new ArrayList<ContractorDTO>();
		if (zipCode != null) {
			Query zq = new Query(Criteria.where("id").is(zipCode.toString()));
			ZipCOde z = mongoTemplate.findOne(zq, ZipCOde.class);
			Log.debug("Zip code query : {} ", zq);
			if (z != null) {
				city = z.getCity();
				state = z.getState();
			}
		}
		if (CollectionUtils.isNotEmpty(trades) && rating != null) {

			TypedAggregation<ContractorDTO> aggregation = Aggregation.newAggregation(ContractorDTO.class,
					Aggregation.unwind("reviews"),
					Aggregation.group("id").avg("reviews.rating").as("avgRating"),
					Aggregation.match(Criteria.where("avgRating").gte(rating)),
					Aggregation.sort(Direction.DESC, "avgRating"));

			String queryString = aggregation.toString();
			System.out.println(" Query String : " + queryString);
			AggregationResults<ContractorDTO> agResults = mongoTemplate.aggregate(aggregation, ContractorDTO.class);

			for (ContractorDTO d : agResults.getMappedResults()) {
				Query q = new Query(Criteria.where("trades").in(trades).and("zipCode").is(zipCode).and("id").is(d.getId()));
				IContractor u = mongoTemplate.findOne(q, Contractor.class);

				if (u != null) {
					System.out.println("u = " + u.toString());
					d.setBusinessName(((Contractor) u).getBusinessName());
					d.setLatitute(((Contractor) u).getLatitute());
					d.setLocation(((Contractor) u).getLocation());
					d.setLogitute(((Contractor) u).getLogitute());
					d.setName(((Contractor) u).getName());
					d.setReviews(((Contractor) u).getReviews());
					d.setTrades(((Contractor) u).getTrades());
					d.setAddress(((Contractor) u).getAddress());
					d.setPhoneNo(((Contractor) u).getPhoneNo());
					d.setZipCode(((Contractor) u).getZipCode());
					d.setCity(city);
					d.setState(state);
					finalList.add(d);
				}
			}
			return finalList;
		}
		if (CollectionUtils.isNotEmpty(trades)) {
			TypedAggregation<ContractorDTO> aggregation = Aggregation.newAggregation(ContractorDTO.class,
					Aggregation.unwind("reviews"),
					Aggregation.group("id").avg("reviews.rating").as("avgRating"),
					Aggregation.sort(Direction.DESC, "avgRating"));

			String queryString = aggregation.toString();
			System.out.println(" Query String : " + queryString);

			AggregationResults<ContractorDTO> agResults = mongoTemplate.aggregate(aggregation, ContractorDTO.class);

			for (ContractorDTO d : agResults.getMappedResults()) {
				System.out.println("d = " + d.toString());
				Query q = new Query(Criteria.where("trades").in(trades).and("id").is(d.getId()).and("zipCode").is(zipCode));
				IContractor u = mongoTemplate.findOne(q, Contractor.class);
				if (u != null) {
					d.setBusinessName(((Contractor) u).getBusinessName());
					d.setLatitute(((Contractor) u).getLatitute());
					d.setLocation(((Contractor) u).getLocation());
					d.setLogitute(((Contractor) u).getLogitute());
					d.setName(((Contractor) u).getName());
					d.setReviews(((Contractor) u).getReviews());
					d.setTrades(((Contractor) u).getTrades());
					d.setAddress(((Contractor) u).getAddress());
					d.setPhoneNo(((Contractor) u).getPhoneNo());
					d.setZipCode(((Contractor) u).getZipCode());
					d.setCity(city);
					d.setState(state);
					finalList.add(d);
				}
			}
			return finalList;

		}
		if (rating != null) {
			TypedAggregation<ContractorDTO> aggregation = Aggregation.newAggregation(ContractorDTO.class,
					Aggregation.unwind("reviews"),
					Aggregation.group("id").avg("reviews.rating").as("avgRating"),
					Aggregation.match(Criteria.where("avgRating").gte(rating)),
					Aggregation.sort(Direction.DESC, "avgRating"));

			String queryString = aggregation.toString();
			System.out.println(" Query String : " + queryString);
			AggregationResults<ContractorDTO> agResults = mongoTemplate.aggregate(aggregation, ContractorDTO.class);

			for (ContractorDTO d : agResults.getMappedResults()) {
				System.out.println("d = " + d.toString());
				Query q = new Query(Criteria.where("id").is(d.getId()).and("zipCode").is(zipCode));
				IContractor u = mongoTemplate.findOne(q, Contractor.class);
				if (u != null) {
					System.out.println("u = " + u.toString());
					d.setBusinessName(((Contractor) u).getBusinessName());
					d.setLatitute(((Contractor) u).getLatitute());
					d.setLocation(((Contractor) u).getLocation());
					d.setLogitute(((Contractor) u).getLogitute());
					d.setName(((Contractor) u).getName());
					d.setReviews(((Contractor) u).getReviews());
					d.setTrades(((Contractor) u).getTrades());
					d.setAddress(((Contractor) u).getAddress());
					d.setPhoneNo(((Contractor) u).getPhoneNo());
					d.setZipCode(((Contractor) u).getZipCode());
					d.setCity(city);
					d.setState(state);
					finalList.add(d);
				}
			}
			return finalList;
		}
		return null;
	}

	public ContractorDTO find(Contractor contractor) {
		Query qry = new Query(Criteria.where("id").is(contractor.getId()));
		Contractor u = mongoTemplate.findOne(qry, Contractor.class);
		ContractorDTO d = new ContractorDTO();
		d.setId(u.getId());
		d.setBusinessName(((Contractor) u).getBusinessName());
		d.setLatitute(((Contractor) u).getLatitute());
		d.setLocation(((Contractor) u).getLocation());
		d.setLogitute(((Contractor) u).getLogitute());
		d.setName(((Contractor) u).getName());
		d.setReviews(((Contractor) u).getReviews());
		d.setTrades(((Contractor) u).getTrades());
		d.setAddress(((Contractor) u).getAddress());
		d.setPhoneNo(((Contractor) u).getPhoneNo());

		if (u.getZipCode() != null) {
			Query zq = new Query(Criteria.where("id").is(u.getZipCode().toString()));
			ZipCOde z = mongoTemplate.findOne(zq, ZipCOde.class);
			Log.debug("Zip code query : {} ", zq);
			if (z != null) {
				d.setCity(z.getCity());
				d.setState(z.getState());
			}
		}
		d.setAvgRating(calculateAverageRating(u));
		return d;
	}

	private Double calculateAverageRating(Contractor u) {
		Double avg = null;
		double i = 0;
		for (Review r : u.getReviews()) {
			i += r.getRating();
		}
		avg = (i != 0 ? i / u.getReviews().size() : null);
		return avg;
	}

	private List<ContractorDTO> wrapContractors(List<Contractor> contractors) {
		AggregationResults<ContractorDTO> aggregationResults = mongoTemplate.aggregate(Aggregation.newAggregation(ContractorDTO.class,
				Aggregation.unwind("reviews"),
				Aggregation.group("id").avg("reviews.rating").as("avgRating"),
				Aggregation.match(Criteria.where("id").in(contractorIds(contractors)))),
				ContractorDTO.class);

		return addContractorData(aggregationResults.getMappedResults());
	}

	private List<ContractorDTO> addContractorData(List<ContractorDTO> contractorDTOs) {
		for (ContractorDTO contractorDTO : contractorDTOs) {
			addContractorData(contractorDTO);
		}

		return contractorDTOs;
	}

	private ContractorDTO addContractorData(ContractorDTO contractorDTO) {
		Query qry = new Query(Criteria.where("id").is(contractorDTO.getId()));
		Contractor contractor = mongoTemplate.findOne(qry, Contractor.class);
		contractorDTO.setBusinessName(contractor.getBusinessName());
		contractorDTO.setLatitute(contractor.getLatitute());
		contractorDTO.setLocation(contractor.getLocation());
		contractorDTO.setLogitute(contractor.getLogitute());
		contractorDTO.setName(contractor.getName());
		contractorDTO.setReviews(contractor.getReviews());
		contractorDTO.setTrades(contractor.getTrades());
		contractorDTO.setAddress(contractor.getAddress());
		contractorDTO.setPhoneNo(contractor.getPhoneNo());

		if (contractorDTO.getZipCode() != null) {
			Query zq = new Query(Criteria.where("id").is(contractorDTO.getZipCode().toString()));
			ZipCOde z = mongoTemplate.findOne(zq, ZipCOde.class);
			Log.debug("Zip code query : {} ", zq);
			if (z != null) {
				contractorDTO.setCity(z.getCity());
				contractorDTO.setState(z.getState());
			}
		}

		return contractorDTO;
	}

	private List<String> contractorIds(List<Contractor> contractors) {
		List<String> ids = new ArrayList<String>();
		for (Contractor contractor : contractors) {
			ids.add(contractor.getId());
		}

		return ids;
	}
}
