package com.atos.campus.pixies.trainingmanagementsystem.controller;

import com.atos.campus.pixies.trainingmanagementsystem.dao.LDMemberDataDAO;
import com.atos.campus.pixies.trainingmanagementsystem.model.LDMemberData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class ControllerLogin {

	@Autowired
	private LDMemberDataDAO memberDataDao;

	@GetMapping(value = "/Login")
	public String viewHomePage() {
	    return "View/Login";
	}

	@PostMapping(value = "/Login")
	public String loginUser(@RequestParam String email, @RequestParam String password, Model model, RedirectAttributes redirectAttrs) {
		/**
		 * Pending: Properly handling the Login from the user input, this is an insecure method.
		 */
		if (email.equals("") || password.equals("")) {
			return "redirect:/Login?error=Invalid+Login+Attempt";
		}
		LDMemberData user = memberDataDao.getByEmail(email);
		if(user != null)
			return "redirect:/" + user.getMemberID();
		return "redirect:/?error=Unknown+Credentials";
		
	}

}
