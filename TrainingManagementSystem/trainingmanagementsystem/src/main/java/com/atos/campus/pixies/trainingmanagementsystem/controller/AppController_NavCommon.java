package com.atos.campus.pixies.trainingmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class AppController_NavCommon {

	@RequestMapping("/layout")
	public String viewLayout() {
	    return "main_layout";
	}

	@RequestMapping("/IndexLBP")
	public String IndexLBP() {
	    return "View/IndexLBP";
	}

	@RequestMapping("/IndexTrainer")
	public String IndexTrainer() {
	    return "View/IndexTrainer";
	}

	@RequestMapping("/InProcessTraining")
	public String InProcessTraining() {
	    return "View/InProcessTraining";
	}

	@RequestMapping("/Login")
	public String Login() {
	    return "View/Login";
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

	@RequestMapping("/TrainningRequest")
	public String TrainningRequest() {
	    return "View/TrainningRequest";
	}

}
