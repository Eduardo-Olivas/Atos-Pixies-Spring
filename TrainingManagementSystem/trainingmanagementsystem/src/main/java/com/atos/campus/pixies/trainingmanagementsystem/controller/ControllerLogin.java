package com.atos.campus.pixies.trainingmanagementsystem.controller;

import com.atos.campus.pixies.trainingmanagementsystem.dao.LDMemberDataDAO;
import com.atos.campus.pixies.trainingmanagementsystem.model.LDMemberData;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class ControllerLogin {

	private static Logger logJava = Logger.getLogger(ControllerLogin.class);
	
	@Autowired
	private LDMemberDataDAO LDBMemberDataDao;

	@GetMapping(value = "/Login")
	public String viewHomePage() {
		logJava.info("/Login");
		
		logJava.info("/View/Login");
		
	    return "View/Login";
	}

	@PostMapping(value = "/Login")
	public String loginUser(@RequestParam String email, @RequestParam String password, Model model, RedirectAttributes redirectAttrs) {
		/**
		 * TODO: Properly handling the Login from the user input.
		 */
		
		logJava.info("/Login - user password");
		
		if (email.equals("") || password.equals("")) {
			return "redirect:/Login?error=Invalid+Login+Attempt";
		}
		LDMemberData user = LDBMemberDataDao.getByEmail(email);
		if(user != null)
			redirectAttrs.addAttribute("id", user.getMemberID());
		System.out.println(email + " Log In.");
		return "redirect:/";
	}

}
