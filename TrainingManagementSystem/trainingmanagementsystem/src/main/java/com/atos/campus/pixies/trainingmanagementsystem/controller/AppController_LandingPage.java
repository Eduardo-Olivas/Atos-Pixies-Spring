package com.atos.campus.pixies.trainingmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController_LandingPage {
	

	@RequestMapping("/LandingPage")
	public String viewHomePage() {
	    return "LandingPage";
	}
	
}
