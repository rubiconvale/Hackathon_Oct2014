package com.model;

 
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
 

@Document(collection = "contractor")
public class Contractor implements Serializable {

	private static final long serialVersionUID = 1L;
@Id
private String id;
private String name;
private String businessName;
private List<Review> reviews;
private List<String> trades;
@GeoSpatialIndexed
private double[] location;
@Transient
private double latitute;
@Transient
private double logitute;
 
public double getLatitute() {
if (location!=null  )
{
this.latitute = location[0];
 
}
return latitute;
}
 
public void setLatitute(double latitute) {
 
this.latitute = latitute;
 
}
 
public double getLogitute() {
if (location!=null  )
{
this.logitute = location[1];
 
}
return logitute;
}
 
public void setLogitute(double logitute) {
 
this.logitute = logitute;
}
 
public void setLocation(double[] location) {
this.location = location;
}
public void setName(String name) {
this.name = name;
}
 
public String getId() {
return id;
}
 
public void setId(String id) {
this.id = id;
}
 
public String getBusinessName() {
return businessName;
}
 
public void setBusinessName(String businessName) {
this.businessName = businessName;
}

public List<String> getTrades() {
	return trades;
}

public void setTrades(List<String> trades) {
	this.trades = trades;
}

public String getName() {
return name;
}
 
public double[] getLocation() {
return location;
}
 
public String toString() {

    return  ReflectionToStringBuilder.toString(this);
}

public List<Review> getReviews() {
	return reviews;
}

public void setReviews(List<Review> reviews) {
	this.reviews = reviews;
}

public class Review implements Serializable{
	private static final long serialVersionUID = 1L;
	private String author;
	private Integer rating;
	private String comment;
	private Date date;
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	 
	public String toString() {

	    return  ReflectionToStringBuilder.toString(this);
	}
}
}