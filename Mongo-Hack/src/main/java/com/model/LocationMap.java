package com.model;

 
import java.util.Arrays;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
 

@Document(collection = "map")
public class LocationMap {
@Id
private String id;
private String name;
private String businessName;
private List<String> type;
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
 
public List<String> getType() {
return type;
}
 
public void setType(List<String> type) {
this.type = type;
}
 
public String getName() {
return name;
}
 
public double[] getLocation() {
return location;
}
 
@Override
public String toString() {
return "Venue [id=" + id + ", name=" + name + ", location="
+ Arrays.toString(location) + "]";
}
}