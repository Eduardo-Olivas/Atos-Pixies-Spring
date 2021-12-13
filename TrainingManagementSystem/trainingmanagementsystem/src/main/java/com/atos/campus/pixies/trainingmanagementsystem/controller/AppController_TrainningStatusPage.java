package com.atos.campus.pixies.trainingmanagementsystem.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class AppController_TrainningStatusPage {
	
	private static Logger logJava = Logger.getLogger(AppController_TrainningStatusPage.class);

	@RequestMapping("/TrainningStatusPage")
	public String viewHomePage() {
		logJava.info("/TrainningStatusPage");
		
	    return "TrainningStatusPage";
	}
	
}
