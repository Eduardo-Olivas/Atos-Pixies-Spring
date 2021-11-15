package com.example.demo.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	

	@RequestMapping("/")
	public ModelAndView index () {
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("index");
	    return modelAndView;
	}
	

	@RequestMapping("/landingpage")
	public String landingPage() {
		return "landingpage";
	}
	
	@RequestMapping("/loginpage")
	public String loginPage() {
		return "loginpage";
	}
	
	@RequestMapping("/navcommon")
	public String navCommon() {
		return "navcommon";
	}
	
	@RequestMapping("/requestformpage")
	public String requestFormPage() {
		return "requestformpage";
	}
	


}
