package com.atos.campus.pixies.trainingmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class AppController_NavCommon {
	

	@RequestMapping("/NavCommon")
	public String viewHomePage() {
	    return "NavCommon";
	}
	
}
