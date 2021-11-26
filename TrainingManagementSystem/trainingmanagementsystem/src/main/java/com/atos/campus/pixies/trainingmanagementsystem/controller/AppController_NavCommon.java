package net.codejava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.dao.LDMemberDataDAO;
import net.codejava.model.LDMemberData;



@Controller
public class AppController_NavCommon {
	

	@RequestMapping("/NavCommon")
	public String viewHomePage() {
	    return "NavCommon";
	}
	
}
