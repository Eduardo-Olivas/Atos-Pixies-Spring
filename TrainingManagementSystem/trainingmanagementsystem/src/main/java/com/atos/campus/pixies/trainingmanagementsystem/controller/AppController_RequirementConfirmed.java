package com.atos.campus.pixies.trainingmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.atos.campus.pixies.trainingmanagementsystem.model.RequirementConfirmed;
import com.atos.campus.pixies.trainingmanagementsystem.dao.RequirementeConfirmedDAO;

@Controller
public class AppController_RequirementConfirmed {

	@Autowired
	private RequirementeConfirmedDAO dao;

	@RequestMapping("/RequirementConfirmed/{requirementID}")
	public ModelAndView get(@PathVariable(name = "requirementID") String requirementID) {
		ModelAndView mav = new ModelAndView("View/RequirementConfirmed");
		RequirementConfirmed RequirementConfirmed = dao.get(requirementID);
		mav.addObject("RequirementConfirmedData", RequirementConfirmed);
	    return mav; 
	}
	@RequestMapping("/RequirementConfirmed")
	public String redirectView() {
		return "View/TrainingExecutionMaster";
	}
}

