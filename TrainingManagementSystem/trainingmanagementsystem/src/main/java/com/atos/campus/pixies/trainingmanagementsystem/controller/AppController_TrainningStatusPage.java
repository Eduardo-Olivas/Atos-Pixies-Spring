package com.atos.campus.pixies.trainingmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class AppController_TrainningStatusPage {
	

	@RequestMapping("/TrainningStatusPage")
	public String viewHomePage() {
	    return "TrainningStatusPage";
	}
	
}