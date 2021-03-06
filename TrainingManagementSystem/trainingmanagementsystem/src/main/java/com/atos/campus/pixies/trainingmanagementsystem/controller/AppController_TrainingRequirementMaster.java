package com.atos.campus.pixies.trainingmanagementsystem.controller;

import java.util.List;

import com.atos.campus.pixies.trainingmanagementsystem.dao.TrainingRequirementMasterDAO;
import com.atos.campus.pixies.trainingmanagementsystem.dao.VerticalMasterDAO;
import com.atos.campus.pixies.trainingmanagementsystem.model.TrainingRequirementMaster;
import com.atos.campus.pixies.trainingmanagementsystem.model.VerticalMaster;

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
public class AppController_TrainingRequirementMaster {
	
	private static Logger logJava = Logger.getLogger(AppController_TrainingRequirementMaster.class);
	
	
	@Autowired
	private TrainingRequirementMasterDAO dao;
	@Autowired
	private VerticalMasterDAO dao1;

	
	
	@RequestMapping("/TrainingRequirementMaster")
	public String viewHomePage1(Model model) {
		List<VerticalMaster> listVerticalMaster = dao1.list();
		TrainingRequirementMaster TrainingRequirementMaster = new TrainingRequirementMaster();
	    model.addAttribute("TrainingRequirementMaster", TrainingRequirementMaster);
		model.addAttribute("verticalMaster", listVerticalMaster);
		
		logJava.info("/TrainingRequirementMaster");
		
	    return "View/OneTrainingRequirement";
	} 
	@RequestMapping("/TrainingRequirementMaster/{id}")
	public String showOneRequirement(@PathVariable String id, Model map) {
		TrainingRequirementMaster training =dao.get(id);
		map.addAttribute("training",training);
		
		logJava.info("/TrainingRequirementMaster/{id}");
		
		return "OneTrainingRequirement";
	}
	
	@RequestMapping("/New/new_TrainingRequirementMaster")
	public String showNewForm(Model model) {
		TrainingRequirementMaster TrainingRequirementMaster = new TrainingRequirementMaster();
	    model.addAttribute("TrainingRequirementMaster", TrainingRequirementMaster);
	    
	    logJava.info("/New/new_TrainingRequirementMaster");
	     
	    return "New/new_form_TrainingRequirementMaster";
	}
	
	@RequestMapping(value = "/save_TrainingRequirementMaster", method = RequestMethod.POST)
	public String save(@ModelAttribute("TrainingRequirementMaster") TrainingRequirementMaster TrainingRequirementMaster) {
		dao.save(TrainingRequirementMaster);
		
		 logJava.info("/save_TrainingRequirementMaster");
		
	    return "redirect:/TrainingRequirementMaster";

	}
	
	@RequestMapping("/Edit/edit_TrainingRequirementMaster/{RequirementID}")
	public ModelAndView showEditForm(@PathVariable(name = "RequirementID") String RequirementID) {
	    ModelAndView mav = new ModelAndView("Edit/edit_form_TrainingRequirementMaster");
	    TrainingRequirementMaster TrainingRequirementMaster = dao.get(RequirementID);
	    mav.addObject("TrainingRequirementMaster", TrainingRequirementMaster);
	     
	    logJava.info("/Edit/edit_TrainingRequirementMaster/{RequirementID}");
	    
	    return mav;
	}
	
	@RequestMapping(value = "/update_TrainingRequirementMaster", method = RequestMethod.POST)
	public String update(@ModelAttribute("TrainingRequirementMaster") TrainingRequirementMaster TrainingRequirementMaster) {
	    dao.update(TrainingRequirementMaster);
	     
	    logJava.info("/update_TrainingRequirementMaster");
	    
	    return "redirect:/Crud/TrainingRequirementMaster";
	}
	
	@RequestMapping("/delete_TrainingRequirementMaster/{RequirementID}")
	public String delete(@PathVariable(name = "RequirementID") String RequirementID) {
	    dao.delete(RequirementID);
	    
	    logJava.info("/delete_TrainingRequirementMaster/{RequirementID}");
	    
	    return "redirect:/Crud/TrainingRequirementMaster";       
	}	
}
