/**
 * 
 */
package com.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.model.LocationMap;

/**
 * @author RNatarajan
 *
 */
@Repository
public interface IReviewsRepositoryDao extends MongoRepository<LocationMap, String> {

}
