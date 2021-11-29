package com.atos.campus.pixies.trainingmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class AppControllerPublic {

	@RequestMapping("/")
	public String viewIndex() {
	    return "index";
	}

	@RequestMapping("/layout")
	public String viewLayout() {
	    return "layout";
	}
}
