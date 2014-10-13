package com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.IReviewsRepositoryDao;
import com.model.LocationMap;

/**
 *
 * @author home
 */
@Controller
@RequestMapping(value = "/mapinsert")
public class MapInsertData {
	private static final Logger log = LoggerFactory.getLogger(MapInsertData.class);
	@Autowired
	IReviewsRepositoryDao repository;

	@RequestMapping(method = RequestMethod.GET)
	public String getCreateForm(Model model) {

		model.addAttribute("locationbean", new LocationMap());
		return "basic/mapinsert";
	}

	@RequestMapping(method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String createContact(@RequestBody LocationMap locationmap,
			BindingResult result) {
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				log.error("Error in uploading: " + error.getCode()
						+ " - " + error.getDefaultMessage());
			}
		}

		double[] tempLocation = { locationmap.getLatitute(),
				locationmap.getLogitute() };
		locationmap.setLocation(tempLocation);
		repository.save(locationmap);
		return "mapinsert";
	}
}