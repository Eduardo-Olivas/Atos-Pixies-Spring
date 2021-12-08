package com.atos.campus.pixies.trainingmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ControllerLogin {

	@GetMapping(value = "/Login")
	public String viewHomePage() {
	    return "View/Login";
	}

	@PostMapping(value = "/Login")
	public String loginUser(@RequestParam String username, @RequestParam String password, Model model) {
		/**
		 * TODO: Properly handling the Login from the user input.
		 */
		if (username.equals("") || password.equals("")) {
			return "redirect:/Login?error=Invalid+Login+Attempt";
		}
		model.addAttribute("username", username);
		System.out.println(username + " Log In.");
		return "redirect:/";
	}

}
