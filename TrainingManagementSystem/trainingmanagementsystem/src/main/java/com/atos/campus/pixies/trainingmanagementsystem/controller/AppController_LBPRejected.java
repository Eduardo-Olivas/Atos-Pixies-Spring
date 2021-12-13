package com.atos.campus.pixies.trainingmanagementsystem.controller;

import java.util.List;

import com.atos.campus.pixies.trainingmanagementsystem.dao.TrainingExecutionMasterDAO;
import com.atos.campus.pixies.trainingmanagementsystem.dao.TrainingProposalsDAO;
import com.atos.campus.pixies.trainingmanagementsystem.model.TrainingExecutionMaster;
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
public class AppController_LBPRejected {
	
	private static Logger logJava = Logger.getLogger(AppController_LBPRejected.class);
	
	@Autowired
	private TrainingProposalsDAO dao;
	

	
	@RequestMapping("/LBPRejected")
	public String viewHomePage(Model model) {
		List<TrainingProposals> listTrainingProposals = dao.listRejected();
		model.addAttribute("listTrainingProposals", listTrainingProposals);
		logJava.info("View/LBPRejected");
	    return "View/LBPRejected";
	}
	
	@RequestMapping("/LBPRejected/{RequirementID}")
	public String showRejected(Model model,@PathVariable(name = "RequirementID") String RequirementID) {
	    List<TrainingProposals> listTrainingProposals = dao.listRejectedRequirementID(RequirementID);
	    model.addAttribute("listTrainingProposals", listTrainingProposals);
	    logJava.info("View/LBPRejected");
	    return "View/LBPRejected";
	}

}
