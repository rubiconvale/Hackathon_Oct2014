package com.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.Contractor;
import com.model.ContractorDTO;
import com.service.IContractorService;

@Controller
public class ContractorController {
 
	@Autowired
	IContractorService service;
	
    @RequestMapping(value = "/contractor", method = RequestMethod.GET)
    public ModelAndView showResults() {
    	List<ContractorDTO> dtos=service.searchContractorByCriteria(Arrays.asList("PAINTING"), 2, 92714);
        return new ModelAndView("contractorView", "contractors", dtos);
    }

	
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView showProfile(@RequestParam String id) {
    	Contractor c=new Contractor();
    	c.setId(id);
    	ContractorDTO dto=service.find(c);
        return new ModelAndView("profileView", "contractor", dto);
    }
    @RequestMapping(value = "/addReview", method = RequestMethod.POST)
    public ModelAndView submit(@Validated @ModelAttribute("contractor")ContractorDTO contractor, 
      BindingResult result, ModelMap modelMap) {
        if (result.hasErrors()) {
        	ModelAndView error=new ModelAndView("error");
            return error;
        }
        ModelAndView model=new ModelAndView("contractorView");
        model.addObject("contractors", contractor);
        return model;
    }
}