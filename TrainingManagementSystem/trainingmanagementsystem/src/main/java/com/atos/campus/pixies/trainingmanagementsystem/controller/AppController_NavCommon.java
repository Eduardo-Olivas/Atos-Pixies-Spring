package com.atos.campus.pixies.trainingmanagementsystem.controller;

import com.atos.campus.pixies.trainingmanagementsystem.dao.TrainingExecutionMasterDAO;
import com.atos.campus.pixies.trainingmanagementsystem.dao.TrainingProposalsDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerNavCommon {

	@Autowired
	private TrainingExecutionMasterDAO trainingExecution;

	@Autowired
	private TrainingProposalsDAO trainingProposal;

	@GetMapping(value = "/")
	public String mainPage(Model model) {
		System.out.println(model);
		if (!model.containsAttribute("username"))
			return "index";
		model.addAttribute("listTrainingExecutionMaster", trainingExecution.list());
	    model.addAttribute("listTrainingProposal", trainingProposal.list());	    
		return "indexLBP";
	}
}
