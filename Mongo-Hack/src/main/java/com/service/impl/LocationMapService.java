package com.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.dao.IReviewsRepositoryDao;
import com.model.LocationMap;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.CommandResult;
import com.mongodb.DBObject;
import com.service.ILocationMapService;
@Service("locationMapService")
public class LocationMapService implements ILocationMapService {

	@Autowired
	IReviewsRepositoryDao reviewsDao;

@Autowired

MongoTemplate mongoTemplate;
	public void insertLocation(LocationMap locationMap) {
		reviewsDao.save(locationMap);
		
	}

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
	


}
