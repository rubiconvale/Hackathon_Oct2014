package com.model;

 
import java.io.Serializable;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
 

@Document(collection = "zipcodes")
public class ZipCOde implements Serializable, IContractor {

	private static final long serialVersionUID = 1L;
@Id
private String id;
private String city;
private String state;
@GeoSpatialIndexed
private double[] location;
@Transient
private double latitute;
@Transient
private double logitute;
private Integer zipCode;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public double[] getLocation() {
	return location;
}
public void setLocation(double[] location) {
	this.location = location;
}
public double getLatitute() {
	return latitute;
}
public void setLatitute(double latitute) {
	this.latitute = latitute;
}
public double getLogitute() {
	return logitute;
}
public void setLogitute(double logitute) {
	this.logitute = logitute;
}
public Integer getZipCode() {
	return zipCode;
}
public void setZipCode(Integer zipCode) {
	this.zipCode = zipCode;
}
@Override
public String toString() {

    return  ReflectionToStringBuilder.toString(this);
}


}