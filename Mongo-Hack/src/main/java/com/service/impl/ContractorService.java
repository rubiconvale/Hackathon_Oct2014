package com.service.impl;

import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.crsh.shell.impl.command.system.help;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.dao.IReviewsRepositoryDao;
import com.model.Contractor;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.CommandResult;
import com.mongodb.DBObject;
import com.service.IContractorService;

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
		double[] {lat,log}).add("num", 10).add("maxDistance", 10).add("distanceMultiplier", (6371 * Math.PI / 180.0d)).add("query", query);
		cmd = documentBuilder.get();
		CommandResult cr =mongoTemplate.executeCommand(cmd);
		return  cr.values();
		}

	public void insert(Contractor contractor) {
		reviewsDao.save(contractor);
		
	}

	public void update(Contractor contractor) {
		
	}

	public List<Contractor> findAllContractors() {

		return mongoTemplate.findAll(Contractor.class);
	}

	public void delete(Contractor contractor) {
		
	}

	public void find(Contractor contractor) {
		// TODO Auto-generated method stub
		
	}
	

	public List<Contractor> searchContractorByCriteria(List<String> trades, Integer rating){
		if(CollectionUtils.isNotEmpty(trades) && rating!=null){

			TypedAggregation<Contractor> aggregation = Aggregation.newAggregation(Contractor.class,
					Aggregation.match(Criteria.where("trades").in(trades)),
		            Aggregation.group("id").avg("reviews.rating").as("avg"),
		            Aggregation.match(Criteria.where("avg").gte(rating)));

			String queryString=new Query(Criteria.where("trades").in(trades)).toString();
			System.out.println(" Query String : "+queryString);
			AggregationResults<Contractor> agResults= mongoTemplate.aggregate(aggregation,Contractor.class);
			return agResults.getMappedResults();		
		}
		if(CollectionUtils.isNotEmpty(trades)){
//			TypedAggregation<Contractor> aggregation = Aggregation.newAggregation(Contractor.class,
//		            Aggregation.match(Criteria.where("avg").gte(rating)),
//		            Aggregation.group("id").avg("reviews.rating").as("avg"),
//		            Aggregation.sort(Direction.DESC, Aggregation.previousOperation()));
//
//			String queryString=new Query(Criteria.where("trades").in(trades)).toString();
//			System.out.println(" Query String : "+queryString);
//			AggregationResults<Contractor> agResults= mongoTemplate.aggregate(aggregation,Contractor.class);
//			return agResults.getMappedResults();
			
		}
		if(rating!=null){

		}		
		return null;
	}

}
