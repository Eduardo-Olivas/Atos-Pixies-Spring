package com.atos.campus.pixies.trainingmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class AppControllerLoginPage {
	

	@RequestMapping("/LoginPage")
	public String viewHomePage() {
	    return "LoginPage";
	}
	
}
