package com.atos.campus.pixies.trainingmanagementsystem.controller;

import java.util.List;

import com.atos.campus.pixies.trainingmanagementsystem.dao.TrainingExecutionMasterDAO;
import com.atos.campus.pixies.trainingmanagementsystem.model.TrainingExecutionMaster;

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
public class AppController_TrainingExecutionMaster {
	
	private static Logger logJava = Logger.getLogger(AppController_TrainingExecutionMaster.class);
	
	@Autowired
	private TrainingExecutionMasterDAO dao;
	
	@RequestMapping("/TrainingExecutionMaster")
	public String viewHomePage(Model model) {
		List<TrainingExecutionMaster> listTrainingExecutionMaster = dao.list();
		model.addAttribute("listTrainingExecutionMaster", listTrainingExecutionMaster);
		logJava.info("TrainingExecutionMaster");
	    return "View/TrainingExecutionMaster";
	}
	
	@RequestMapping("/new_TrainingExecutionMaster")
	public String showNewForm(Model model) {
		TrainingExecutionMaster TrainingExecutionMaster = new TrainingExecutionMaster(null, null, null, null, null, 0, null, 0, null);
	    model.addAttribute("TrainingExecutionMaster", TrainingExecutionMaster);
	    logJava.info("/new_TrainingExecutionMaster");
	    return "new_form_TrainingExecutionMaster";
	}
	
	@RequestMapping("/new_TrainingExecutionMaster/{id}")
	public String showNewFormExe(@PathVariable String id, Model model) {
		TrainingExecutionMaster TrainingExecutionMaster = new TrainingExecutionMaster(null, id, null, null, null, 0, null, 0, null);
	    model.addAttribute("TrainingExecutionMaster", TrainingExecutionMaster);
	    model.addAttribute("proposalID", id);
	    logJava.info("/new_TrainingExecutionMaster/{id}");
	    return "New/new_form_TrainingExecutionMaster";
	}
	
	@RequestMapping(value = "/save_TrainingExecutionMaster", method = RequestMethod.POST)
	public String save(@ModelAttribute("TrainingExecutionMaster") TrainingExecutionMaster TrainingExecutionMaster) {
	    dao.save(TrainingExecutionMaster);
	    logJava.info("/save_TrainingExecutionMaster");
	    return "redirect:/index-Trainer/allRequirements";
	}
	
	@RequestMapping("/edit_TrainingExecutionMaster/{RequirementID}")
	public ModelAndView showEditForm(@PathVariable(name = "RequirementID") String RequirementID) {
	    ModelAndView mav = new ModelAndView("Edit/edit_form_TrainingExecutionMaster");
	    TrainingExecutionMaster TrainingExecutionMaster = dao.get(RequirementID);
	    mav.addObject("View/TrainingExecutionMaster", TrainingExecutionMaster);
	    logJava.info("/edit_TrainingExecutionMaster/{RequirementID}");
	    return mav;
	}
	
	@RequestMapping(value = "/update_TrainingExecutionMaster", method = RequestMethod.POST)
	public String update(@ModelAttribute("TrainingExecutionMaster") TrainingExecutionMaster TrainingExecutionMaster) {
	    dao.update(TrainingExecutionMaster);
	    
	    logJava.info("/update_TrainingExecutionMaster");
	    return "redirect:/View/TrainingExecutionMaster";
	}
	
	@RequestMapping("/delete_TrainingExecutionMaster/{RequirementID}")
	public String delete(@PathVariable(name = "RequirementID") String RequirementID) {
	    dao.delete(RequirementID);
	    
	    logJava.info("/delete_TrainingExecutionMaster/{RequirementID}");
	    return "redirect:/View/TrainingExecutionMaster";      
	}	
}
