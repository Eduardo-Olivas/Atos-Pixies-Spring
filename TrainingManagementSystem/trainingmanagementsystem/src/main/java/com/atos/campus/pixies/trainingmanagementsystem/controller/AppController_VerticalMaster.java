package com.atos.campus.pixies.trainingmanagementsystem.controller;

import java.util.List;

import com.atos.campus.pixies.trainingmanagementsystem.dao.VerticalMasterDAO;
import com.atos.campus.pixies.trainingmanagementsystem.model.VerticalMaster;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class AppController_VerticalMaster {
	
	private static Logger logJava = Logger.getLogger(AppController_VerticalMaster.class);
	
	@Autowired
	private VerticalMasterDAO dao;
	
	@RequestMapping("/Crud/VerticalMaster")
	public String viewHomePage(Model model) {
		List<VerticalMaster> listVerticalMaster = dao.list();
		model.addAttribute("listVerticalMaster", listVerticalMaster);
		
		logJava.info("/Crud/VerticalMaster");
		
	    return "/Crud/VerticalMaster";
	}
	
	@RequestMapping("/New/new_VerticalMaster")
	public String showNewForm(Model model) {
		VerticalMaster VerticalMaster = new VerticalMaster();
	    model.addAttribute("VerticalMaster", VerticalMaster);
	    
		logJava.info("/New/new_VerticalMaster");
	     
	    return "New/new_form_VerticalMaster";
	}
	
	@RequestMapping(value = "/save_VerticalMaster", method = RequestMethod.POST)
	public String save(@ModelAttribute("VerticalMaster") VerticalMaster VerticalMaster) {
	    dao.save(VerticalMaster);
	    
	    logJava.info("/save_VerticalMaster");
	    
	    return "redirect:/Crud/VerticalMaster";
	}
	
	@RequestMapping("/Edit/edit_form_VerticalMaster/{VID}")
	public ModelAndView showEditForm(@PathVariable(name = "VID") String VID) {
	    ModelAndView mav = new ModelAndView("Edit/edit_form_VerticalMaster");
	    VerticalMaster VerticalMaster = dao.get(VID);
	    mav.addObject("VerticalMaster", VerticalMaster);
	    
	    logJava.info("/Edit/edit_form_VerticalMaster/{VID}");
	     
	    return mav;
	}
	
	@RequestMapping(value = "/update_VerticalMaster", method = RequestMethod.POST)
	public String update(@ModelAttribute("VerticalMaster") VerticalMaster VerticalMaster) {
	    dao.update(VerticalMaster);
	    logJava.info("/update_VerticalMaster");
	    
	    return "redirect:Crud/VerticalMaster";
	}
	
	@RequestMapping("/delete_VerticalMaster/{VID}")
	public String delete(@PathVariable(name = "VID") String VID) {
	    dao.delete(VID);
	    logJava.info("/delete_VerticalMaster/{VID}");
	    
	    return "redirect:Crud/VerticalMaster";       
	}	
}
