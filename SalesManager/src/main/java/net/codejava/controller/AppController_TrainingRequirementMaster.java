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

import net.codejava.dao.TrainingRequirementMasterDAO;
import net.codejava.model.TrainingRequirementMaster;



@Controller
public class AppController_TrainingRequirementMaster {
	
	@Autowired
	private TrainingRequirementMasterDAO dao;
	
	@RequestMapping("/TrainingRequirementMaster")
	public String viewHomePage(Model model) {
		List<TrainingRequirementMaster> listTrainingRequirementMaster = dao.list();
		model.addAttribute("listTrainingRequirementMaster", listTrainingRequirementMaster);
	    return "TrainingRequirementMaster";
	}
	
	@RequestMapping("/new_TrainingRequirementMaster")
	public String showNewForm(Model model) {
		TrainingRequirementMaster TrainingRequirementMaster = new TrainingRequirementMaster();
	    model.addAttribute("TrainingRequirementMaster", TrainingRequirementMaster);
	     
	    return "new_form_TrainingRequirementMaster";
	}
	
	@RequestMapping(value = "/save_TrainingRequirementMaster", method = RequestMethod.POST)
	public String save(@ModelAttribute("TrainingRequirementMaster") TrainingRequirementMaster TrainingRequirementMaster) {
	    dao.save(TrainingRequirementMaster);
	     
	    return "redirect:/TrainingRequirementMaster";
	}
	
	@RequestMapping("/edit_TrainingRequirementMaster/{RequirementID}")
	public ModelAndView showEditForm(@PathVariable(name = "RequirementID") String RequirementID) {
	    ModelAndView mav = new ModelAndView("edit_form_TrainingRequirementMaster");
	    TrainingRequirementMaster TrainingRequirementMaster = dao.get(RequirementID);
	    mav.addObject("TrainingRequirementMaster", TrainingRequirementMaster);
	     
	    return mav;
	}
	
	@RequestMapping(value = "/update_TrainingRequirementMaster", method = RequestMethod.POST)
	public String update(@ModelAttribute("TrainingRequirementMaster") TrainingRequirementMaster TrainingRequirementMaster) {
	    dao.update(TrainingRequirementMaster);
	     
	    return "redirect:/TrainingRequirementMaster";
	}
	
	@RequestMapping("/delete_TrainingRequirementMaster/{RequirementID}")
	public String delete(@PathVariable(name = "RequirementID") String RequirementID) {
	    dao.delete(RequirementID);
	    return "redirect:/TrainingRequirementMaster";       
	}	
}
