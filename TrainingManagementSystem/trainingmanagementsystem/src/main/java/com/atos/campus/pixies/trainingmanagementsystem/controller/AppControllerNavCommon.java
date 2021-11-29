package com.atos.campus.pixies.trainingmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class AppControllerNavCommon {

	@RequestMapping("/")
	public String viewIndex() {
	    return "index";
	}

	@RequestMapping("/NavCommon")
	public String viewHomePage() {
	    return "NavCommon";
	}
	
}
