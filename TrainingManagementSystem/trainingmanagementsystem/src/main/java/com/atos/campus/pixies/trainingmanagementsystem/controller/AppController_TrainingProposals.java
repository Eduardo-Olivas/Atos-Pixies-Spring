package com.atos.campus.pixies.trainingmanagementsystem.controller;

import java.util.List;

import com.atos.campus.pixies.trainingmanagementsystem.dao.TrainingProposalsDAO;
import com.atos.campus.pixies.trainingmanagementsystem.model.TrainingProposals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class AppController_TrainingProposals {
	
	@Autowired
	private TrainingProposalsDAO dao;
	
	@RequestMapping("/TrainingProposals")
	public String viewHomePage(Model model) {
		List<TrainingProposals> listTrainingProposals = dao.list();
		model.addAttribute("listTrainingProposals", listTrainingProposals);
	    return "TrainingProposals";
	}
	
	@RequestMapping("/new_TrainingProposals")
	public String showNewForm(Model model) {
		TrainingProposals TrainingProposals = new TrainingProposals();
	    model.addAttribute("TrainingProposals", TrainingProposals);
	     
	    return "/new/new_form_TrainingProposals";
	}
	
	@RequestMapping("/new_TrainingProposals/{id}")
	public String showNewFormWithOther(@PathVariable String id, Model model) {
		TrainingProposals TrainingProposals = new TrainingProposals();
	    model.addAttribute("TrainingProposals", TrainingProposals);
	    model.addAttribute("executionID", id);
	     
	    return "/new/new_form_TrainingProposals";
	}
	
	@RequestMapping(value = "/save_TrainingProposals", method = RequestMethod.POST)
	public String save(@ModelAttribute("TrainingProposals") TrainingProposals TrainingProposals) {
	    dao.save(TrainingProposals);
	     
	    return "redirect:/TrainingExecutionMaster";
	}
	
	@RequestMapping("/edit_TrainingProposals/{ProporsalID}")
	public ModelAndView showEditForm(@PathVariable(name = "ProporsalID") String ProporsalID) {
	    ModelAndView mav = new ModelAndView("edit_form_TrainingProposals");
	    TrainingProposals TrainingProposals = dao.get(ProporsalID);
	    mav.addObject("TrainingProposals", TrainingProposals);
	     
	    return mav;
	}
	
	@RequestMapping(value = "/update_TrainingProposals", method = RequestMethod.POST)
	public String update(@ModelAttribute("TrainingProposals") TrainingProposals TrainingProposals) {
	    dao.update(TrainingProposals);
	     
	    return "redirect:/TrainingProposals";
	}
	
	@RequestMapping("/delete_TrainingProposals/{ProporsalID}")
	public String delete(@PathVariable(name = "ProporsalID") String ProporsalID) {
	    dao.delete(ProporsalID);
	    return "redirect:/TrainingProposals";       
	}	
}
