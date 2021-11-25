package com.atos.campus.pixies.trainingmanagementsystem.controller;

import java.util.List;

import com.atos.campus.pixies.trainingmanagementsystem.dao.VerticalMasterDAO;
import com.atos.campus.pixies.trainingmanagementsystem.model.VerticalMaster;

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
	
	@Autowired
	private VerticalMasterDAO dao;
	
	@RequestMapping("/VerticalMaster")
	public String viewHomePage(Model model) {
		List<VerticalMaster> listVerticalMaster = dao.list();
		model.addAttribute("listVerticalMaster", listVerticalMaster);
	    return "VerticalMaster";
	}
	
	@RequestMapping("/new_VerticalMaster")
	public String showNewForm(Model model) {
		VerticalMaster VerticalMaster = new VerticalMaster();
	    model.addAttribute("VerticalMaster", VerticalMaster);
	     
	    return "new_form_VerticalMaster";
	}
	
	@RequestMapping(value = "/save_VerticalMaster", method = RequestMethod.POST)
	public String save(@ModelAttribute("VerticalMaster") VerticalMaster VerticalMaster) {
	    dao.save(VerticalMaster);
	     
	    return "redirect:/VerticalMaster";
	}
	
	@RequestMapping("/edit_VerticalMaster/{VID}")
	public ModelAndView showEditForm(@PathVariable(name = "VID") String VID) {
	    ModelAndView mav = new ModelAndView("edit_form_VerticalMaster");
	    VerticalMaster VerticalMaster = dao.get(VID);
	    mav.addObject("VerticalMaster", VerticalMaster);
	     
	    return mav;
	}
	
	@RequestMapping(value = "/update_VerticalMaster", method = RequestMethod.POST)
	public String update(@ModelAttribute("VerticalMaster") VerticalMaster VerticalMaster) {
	    dao.update(VerticalMaster);
	     
	    return "redirect:/VerticalMaster";
	}
	
	@RequestMapping("/delete_VerticalMaster/{VID}")
	public String delete(@PathVariable(name = "VID") String VID) {
	    dao.delete(VID);
	    return "redirect:/VerticalMaster";       
	}	
}
