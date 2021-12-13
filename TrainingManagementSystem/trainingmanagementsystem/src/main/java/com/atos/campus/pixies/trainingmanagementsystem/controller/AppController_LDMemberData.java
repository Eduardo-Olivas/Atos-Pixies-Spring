package com.atos.campus.pixies.trainingmanagementsystem.controller;

import java.util.List;

import com.atos.campus.pixies.trainingmanagementsystem.dao.LDMemberDataDAO;
import com.atos.campus.pixies.trainingmanagementsystem.model.LDMemberData;

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
public class AppController_LDMemberData {
	
	private static Logger logJava = Logger.getLogger(AppController_LDMemberData.class);
	
	@Autowired
	private LDMemberDataDAO dao;
	
	@RequestMapping("/Crud/LDMemberData")
	public String viewHomePage(Model model) {
		List<LDMemberData> listLDMemberData = dao.list();
		model.addAttribute("listLDMemberData", listLDMemberData);
		logJava.info("new_form_LDMemberData");
	    return "Crud/LDMemberData";
	}
	
	@RequestMapping("/New/new_LDMemberData")
	public String showNewForm(Model model) {
		LDMemberData LDMemberData = new LDMemberData();
	    model.addAttribute("LDMemberData", LDMemberData);
	    logJava.info("new_form_LDMemberData");
	    return "new_form_LDMemberData";
	}
	
	@RequestMapping(value = "/save_LDMemberData", method = RequestMethod.POST)
	public String save(@ModelAttribute("LDMemberData") LDMemberData LDMemberData) {
	    dao.save(LDMemberData);
	    logJava.info("redirect:/Crud/LDMemberData");
	    return "redirect:/Crud/LDMemberData";
	}
	
	@RequestMapping("/Edit/edit_LDMemberData/{MemberID}")
	public ModelAndView showEditForm(@PathVariable(name = "MemberID") String MemberID) {
	    ModelAndView mav = new ModelAndView("Edit/edit_form_LDMemberData");
	    LDMemberData LDMemberData = dao.get(MemberID);
	    mav.addObject("LDMemberData", LDMemberData);
	    logJava.info("/Edit/edit_LDMemberData/{MemberID}");
	    return mav;
	}
	
	@RequestMapping(value = "/update_LDMemberData", method = RequestMethod.POST)
	public String update(@ModelAttribute("LDMemberData") LDMemberData LDMemberData) {
	    dao.update(LDMemberData);
	    logJava.info("redirect:/Crud/LDMemberData");
	    return "redirect:/Crud/LDMemberData";
	}
	
	@RequestMapping("/delete_LDMemberData/{MemberID}")
	public String delete(@PathVariable(name = "MemberID") String MemberID) {
	    dao.delete(MemberID);
	    logJava.info("redirect:/Crud/LDMemberData");
	    return "redirect:/Crud/LDMemberData";       
	}	
}
