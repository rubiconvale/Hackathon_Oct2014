package com.controller;


 
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.ILocationMapService;
 
/**
*
* @author home
*/
@Controller
@RequestMapping(value = "/mapnearby")
public class SearchNearController {
private  final Logger logger = LoggerFactory.getLogger(SearchNearController.class);
@Autowired
ILocationMapService service;

 
@RequestMapping(value="/{lat}/{longit}/{nearby}",method = RequestMethod.GET)
public @ResponseBody Collection<Object>  getCreateForm(@PathVariable  double lat, @PathVariable  double longit , @PathVariable double nearby ) {
 logger.debug("Map nearby Results .....");
System.out.println("id nme " +   lat+ longit + nearby);
 
// GeoResults<LocationMap> locMap = repository.getnearestLocation(longit, lat, nearby);
//model.addAttribute("locationbean",repository.getBusinessByNameAndBusiness(name, business));
Collection<Object> locMap=service.getNearestLocation(lat,longit, nearby);
return locMap;
}


}