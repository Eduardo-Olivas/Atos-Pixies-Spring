package com.atos.campus.pixies.trainingmanagementsystem.controller;

import java.util.List;

import com.atos.campus.pixies.trainingmanagementsystem.dao.TrainingExecutionMasterDAO;
import com.atos.campus.pixies.trainingmanagementsystem.model.TrainingExecutionMaster;

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
	
	@Autowired
	private TrainingExecutionMasterDAO dao;
	
	@RequestMapping("/TrainingExecutionMaster")
	public String viewHomePage(Model model) {
		List<TrainingExecutionMaster> listTrainingExecutionMaster = dao.list();
		model.addAttribute("listTrainingExecutionMaster", listTrainingExecutionMaster);
	    return "TrainingExecutionMaster";
	}
	
	@RequestMapping("/new_TrainingExecutionMaster")
	public String showNewForm(Model model) {
		TrainingExecutionMaster TrainingExecutionMaster = new TrainingExecutionMaster();
	    model.addAttribute("TrainingExecutionMaster", TrainingExecutionMaster);
	     
	    return "new_form_TrainingExecutionMaster";
	}
	
	@RequestMapping(value = "/save_TrainingExecutionMaster", method = RequestMethod.POST)
	public String save(@ModelAttribute("TrainingExecutionMaster") TrainingExecutionMaster TrainingExecutionMaster) {
	    dao.save(TrainingExecutionMaster);
	     
	    return "redirect:/TrainingExecutionMaster";
	}
	
	@RequestMapping("/edit_TrainingExecutionMaster/{RequirementID}")
	public ModelAndView showEditForm(@PathVariable(name = "RequirementID") String RequirementID) {
	    ModelAndView mav = new ModelAndView("edit_form_TrainingExecutionMaster");
	    TrainingExecutionMaster TrainingExecutionMaster = dao.get(RequirementID);
	    mav.addObject("TrainingExecutionMaster", TrainingExecutionMaster);
	     
	    return mav;
	}
	
	@RequestMapping(value = "/update_TrainingExecutionMaster", method = RequestMethod.POST)
	public String update(@ModelAttribute("TrainingExecutionMaster") TrainingExecutionMaster TrainingExecutionMaster) {
	    dao.update(TrainingExecutionMaster);
	     
	    return "redirect:/TrainingExecutionMaster";
	}
	
	@RequestMapping("/delete_TrainingExecutionMaster/{RequirementID}")
	public String delete(@PathVariable(name = "RequirementID") String RequirementID) {
	    dao.delete(RequirementID);
	    return "redirect:/TrainingExecutionMaster";       
	}	
}
