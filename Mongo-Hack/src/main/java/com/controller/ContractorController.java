package com.controller;

import com.model.Contractor;
import com.model.ContractorDTO;
import com.model.ReviewDTO;
import com.service.IContractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Arrays;
import java.util.List;

@Controller
public class ContractorController {

	@Autowired
	IContractorService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView indexView(@Validated @ModelAttribute("input") InputDTO in) {
		return new ModelAndView("index", "input", new InputDTO());
	}

	@RequestMapping(value = "/searchContractor", method = RequestMethod.POST)
	public ModelAndView showResults(@Validated @ModelAttribute("input") InputDTO in) {
		List<ContractorDTO> dtos = service.searchContractorByCriteria(Arrays.asList(in.getTrade()), in.getRating(), in.getZipCode());
//		List<ContractorDTO> dtos = service.findAllContractors();
		return new ModelAndView("contractorView", "contractors", dtos);
	}


	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView showProfile(@RequestParam String id) {
		Contractor c = new Contractor();
		c.setId(id);
		ContractorDTO dto = service.find(c);
		return new ModelAndView("profileView", "contractor", dto);
	}

	@RequestMapping(value = "/addReview", method = RequestMethod.GET)
	public ModelAndView addReview(@RequestParam String id) {
		return new ModelAndView("addReview", "contractorId", id);
	}

	@RequestMapping(value = "/addReview", method = RequestMethod.POST)
	public String submit(@Validated @ModelAttribute("review") ReviewDTO reviewDTO,
							   BindingResult result, ModelMap modelMap) {
		if (result.hasErrors()) {
			return "forward:/error"; // I don't think this works
		}

		service.updateReview(reviewDTO);

		return "redirect:/profile?id=" + reviewDTO.getContractorId();
	}
}