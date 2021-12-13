package com.atos.campus.pixies.trainingmanagementsystem.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class AppController_RequestFormPage {
	

	private static Logger logJava = Logger.getLogger(AppController_RequestFormPage.class);
	
	@RequestMapping("/RequestFormPage")
	public String viewHomePage() {
		logJava.info("RequestFormPage");
	    return "RequestFormPage";
	}
	
}
