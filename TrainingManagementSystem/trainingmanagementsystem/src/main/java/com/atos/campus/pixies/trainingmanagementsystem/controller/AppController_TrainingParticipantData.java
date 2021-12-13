package com.atos.campus.pixies.trainingmanagementsystem.controller;

import java.util.List;

import com.atos.campus.pixies.trainingmanagementsystem.dao.TrainingParticipantDataDAO;
import com.atos.campus.pixies.trainingmanagementsystem.model.TrainingParticipantData;

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
public class AppController_TrainingParticipantData {
	
	private static Logger logJava = Logger.getLogger(AppController_TrainingParticipantData.class);
	
	@Autowired
	private TrainingParticipantDataDAO dao;
	
	@RequestMapping("/TrainingParticipantData")
	public String viewHomePage(Model model) {
		List<TrainingParticipantData> listTrainingParticipantData = dao.list();
		model.addAttribute("listTrainingParticipantData", listTrainingParticipantData);
		logJava.info("TrainingParticipantData");
		
	    return "TrainingParticipantData";
	}
	
	@RequestMapping("/new_TrainingParticipantData")
	public String showNewForm(Model model) {
		TrainingParticipantData TrainingParticipantData = new TrainingParticipantData();
	    model.addAttribute("TrainingParticipantData", TrainingParticipantData);
	     
	    logJava.info("/new_TrainingParticipantData");
	    return "new_form_TrainingParticipantData";
	}
	
	@RequestMapping(value = "/save_TrainingParticipantData", method = RequestMethod.POST)
	public String save(@ModelAttribute("TrainingParticipantData") TrainingParticipantData TrainingParticipantData) {
	    dao.save(TrainingParticipantData);
	     
	    logJava.info("/save_TrainingParticipantData");
	    return "redirect:/TrainingParticipantData";
	}
	
	@RequestMapping("Edit/edit_TrainingParticipantData/{ParticipantID}")
	public ModelAndView showEditForm(@PathVariable(name = "ParticipantID") String ParticipantID) {
	    ModelAndView mav = new ModelAndView("Edit/edit_form_TrainingParticipantData");
	    TrainingParticipantData TrainingParticipantData = dao.get(ParticipantID);
	    mav.addObject("TrainingParticipantData", TrainingParticipantData);
	     
	    logJava.info("Edit/edit_TrainingParticipantData/{ParticipantID}");
	    return mav;
	}
	
	@RequestMapping(value = "/update_TrainingParticipantData", method = RequestMethod.POST)
	public String update(@ModelAttribute("TrainingParticipantData") TrainingParticipantData TrainingParticipantData) {
	    dao.update(TrainingParticipantData);
	     
	    logJava.info("/update_TrainingParticipantData");
	    return "redirect:/TrainingParticipantData";
	}
	
	@RequestMapping("/delete_TrainingParticipantData/{ParticipantID}")
	public String delete(@PathVariable(name = "ParticipantID") String ParticipantID) {
	    dao.delete(ParticipantID);
	    logJava.info("/delete_TrainingParticipantData/{ParticipantID}");
	    return "redirect:/TrainingParticipantData";       
	}	
}
