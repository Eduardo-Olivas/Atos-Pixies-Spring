package net.codejava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.dao.TrainingProposalsDAO;
import net.codejava.model.TrainingProposals;



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
	     
	    return "new_form_TrainingProposals";
	}
	
	@RequestMapping(value = "/save_TrainingProposals", method = RequestMethod.POST)
	public String save(@ModelAttribute("TrainingProposals") TrainingProposals TrainingProposals) {
	    dao.save(TrainingProposals);
	     
	    return "redirect:/TrainingProposals";
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
