package com.atos.campus.pixies.trainingmanagementsystem.controller;

import java.util.List;

import com.atos.campus.pixies.trainingmanagementsystem.dao.TrainingProposalsDAO;
import com.atos.campus.pixies.trainingmanagementsystem.model.TrainingProposals;

import org.apache.log4j.Logger;
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
	
	private static Logger logJava = Logger.getLogger(AppController_TrainingProposals.class);
	
	@Autowired
	private TrainingProposalsDAO dao;
	
	@RequestMapping("/Crud/TrainingProposals")
	public String viewHomePage(Model model) {
		List<TrainingProposals> listTrainingProposals = dao.list();
		model.addAttribute("listTrainingProposals", listTrainingProposals);
		
		logJava.info("/Crud/TrainingProposals");
	    return "Crud/TrainingProposals";
	}
	@RequestMapping("/Crud/TrainingProposalsRejected")
	public String viewHomePageRejected(Model model) {
		List<TrainingProposals> listTrainingProposals = dao.listRejected();
		model.addAttribute("listTrainingProposals", listTrainingProposals);
		
		logJava.info("/Crud/TrainingProposalsRejected");
	    
		return "Crud/TrainingProposalsRejected";
	}
	
	
	
	@RequestMapping("/index-Trainer/allRequirements")
	public String viewIndexPage(Model model) {
		List<TrainingProposals> listTrainingProposals = dao.list();
		model.addAttribute("listTrainingProposals", listTrainingProposals);
		logJava.info("/index-Trainer/allRequirements");
		
	    return "View/IndexTrainer";
	}
	
	@RequestMapping("/New/new_TrainingProposals")
	public String showNewForm(Model model) {
		TrainingProposals TrainingProposals = new TrainingProposals();
	    model.addAttribute("TrainingProposals", TrainingProposals);
	    logJava.info("/New/new_TrainingProposals");
		
	    return "New/new_form_TrainingProposals";
	}
	
	@RequestMapping("/New/new_TrainingProposals/{id}")
	public String showNewFormWithOther(@PathVariable String id, Model model) {
		TrainingProposals TrainingProposals = new TrainingProposals();
	    model.addAttribute("TrainingProposals", TrainingProposals);
	    model.addAttribute("requirementID", id);
	    model.addAttribute("id", id);
	     
	    logJava.info("/New/new_TrainingProposals/{id}");
	    
	    return "New/new_form_TrainingProposals";
	}
	
	@RequestMapping(value = "/save_TrainingProposals", method = RequestMethod.POST)
	public String save(@ModelAttribute("TrainingProposals") TrainingProposals TrainingProposals) {
	    dao.save(TrainingProposals);
	    
	    logJava.info("/save_TrainingProposals");
	     
	    return "redirect:/Crud/TrainingProposals";
	}
	
	@RequestMapping("/Edit/edit_TrainingProposals/{ProposalID}")
	public ModelAndView showEditForm(@PathVariable(name = "ProposalID") String ProposalID) {
	    ModelAndView mav = new ModelAndView("Edit/edit_form_TrainingProposals");
	    TrainingProposals TrainingProposals = dao.get(ProposalID);
	    mav.addObject("TrainingProposals", TrainingProposals);
	    
	    logJava.info("/Edit/edit_TrainingProposals/{ProposalID}");
	     
	    return mav;
	}
	

	
	@RequestMapping(value = "/update_TrainingProposals", method = RequestMethod.POST)
	public String update(@ModelAttribute("TrainingProposals") TrainingProposals TrainingProposals) {
	    dao.update(TrainingProposals);
	    
	    logJava.info("/update_TrainingProposals");
	     
	    return "redirect:/Crud/TrainingProposals";
	}
	
	@RequestMapping("/delete_TrainingProposals/{ProposalID}")
	public String delete(@PathVariable(name = "ProposalID") String ProposalID) {
	    dao.delete(ProposalID);
	    
	    logJava.info("/delete_TrainingProposals/{ProposalID}");
	    return "redirect:/Crud/TrainingProposals";       
	}	
}
