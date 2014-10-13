/**
 * 
 */
package com.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.model.Contractor;

/**
 * @author RNatarajan
 *
 */
@Repository
public interface IReviewsRepositoryDao extends MongoRepository<Contractor, String> {

}
