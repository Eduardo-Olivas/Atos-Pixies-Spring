package com.atos.campus.pixies.trainingmanagementsystem.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class AppController_NavCommon {

	private static Logger logJava = Logger.getLogger(AppController_NavCommon.class);
	
	@RequestMapping("/CreateTrainingRequirementMaster")
	public String TrainingRequirementMaster() {
	    logJava.info("CreateTrainingRequirementMaster");
	    return "Crud/TrainingRequirementMaster";
	}

	@RequestMapping("/NewRequirement")
	public String NewRequirement() {
		logJava.info("/NewRequirement");
	    return "View/NewRequirement";
	}

	@RequestMapping("/RejectedLBP")
	public String RejectedLBP() {
		logJava.info("/RejectedLBP");
	    return "View/RejectedLBP";
	}

	@RequestMapping("/RequirementConfirmed")
	public String RequirementConfirmed() {
		logJava.info("/RequirementConfirmed");
	    return "View/RequirementConfirmed";
	}

	@RequestMapping("/TrainerAcceptance")
	public String TrainerAcceptance() {
		logJava.info("/TrainerAcceptance");
	    return "View/TrainerAcceptance";
	}

	@RequestMapping("/TrainingRequest")
	public String TrainingRequest() {
		logJava.info("/TrainingRequest");
	    return "View/TrainingRequest";
	}

}
