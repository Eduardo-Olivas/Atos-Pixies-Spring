package com.atos.campus.pixies.trainingmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class AppController_NavCommon {

	@RequestMapping("/CreateTrainingRequirementMaster")
	public String TrainingRequirementMaster() {
	    return "Crud/TrainingRequirementMaster";
	}

	@RequestMapping("/NewRequirement")
	public String NewRequirement() {
	    return "View/NewRequirement";
	}

	@RequestMapping("/RejectedLBP")
	public String RejectedLBP() {
	    return "View/RejectedLBP";
	}

	@RequestMapping("/RequirementConfirmed")
	public String RequirementConfirmed() {
	    return "View/RequirementConfirmed";
	}

	@RequestMapping("/TrainerAcceptance")
	public String TrainerAcceptance() {
	    return "View/TrainerAcceptance";
	}

	@RequestMapping("/TrainingRequest")
	public String TrainingRequest() {
	    return "View/TrainingRequest";
	}

}
