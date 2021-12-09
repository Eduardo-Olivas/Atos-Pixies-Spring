package com.atos.campus.pixies.trainingmanagementsystem.controller;

import java.util.List;

import com.atos.campus.pixies.trainingmanagementsystem.dao.TrainingParticipantDataDAO;
import com.atos.campus.pixies.trainingmanagementsystem.model.TrainingParticipantData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class AppController_TrainingParticipantData {
	
	@Autowired
	private TrainingParticipantDataDAO dao;
	
	@RequestMapping("/TrainingParticipantData")
	public String viewHomePage(Model model) {
		List<TrainingParticipantData> listTrainingParticipantData = dao.list();
		model.addAttribute("listTrainingParticipantData", listTrainingParticipantData);
	    return "TrainingParticipantData";
	}
	
	@RequestMapping("/new_TrainingParticipantData")
	public String showNewForm(Model model) {
		TrainingParticipantData TrainingParticipantData = new TrainingParticipantData();
	    model.addAttribute("TrainingParticipantData", TrainingParticipantData);
	     
	    return "new_form_TrainingParticipantData";
	}
	
	@RequestMapping(value = "/save_TrainingParticipantData", method = RequestMethod.POST)
	public String save(@ModelAttribute("TrainingParticipantData") TrainingParticipantData TrainingParticipantData) {
	    dao.save(TrainingParticipantData);
	     
	    return "redirect:/TrainingParticipantData";
	}
	
	@RequestMapping("Edit/edit_TrainingParticipantData/{ParticipantID}")
	public ModelAndView showEditForm(@PathVariable(name = "ParticipantID") String ParticipantID) {
	    ModelAndView mav = new ModelAndView("Edit/edit_form_TrainingParticipantData");
	    TrainingParticipantData TrainingParticipantData = dao.get(ParticipantID);
	    mav.addObject("TrainingParticipantData", TrainingParticipantData);
	     
	    return mav;
	}
	
	@RequestMapping(value = "/update_TrainingParticipantData", method = RequestMethod.POST)
	public String update(@ModelAttribute("TrainingParticipantData") TrainingParticipantData TrainingParticipantData) {
	    dao.update(TrainingParticipantData);
	     
	    return "redirect:/TrainingParticipantData";
	}
	
	@RequestMapping("/delete_TrainingParticipantData/{ParticipantID}")
	public String delete(@PathVariable(name = "ParticipantID") String ParticipantID) {
	    dao.delete(ParticipantID);
	    return "redirect:/TrainingParticipantData";       
	}	
}
