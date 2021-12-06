package com.atos.campus.pixies.trainingmanagementsystem.controller;

import java.util.List;

import com.atos.campus.pixies.trainingmanagementsystem.dao.LDRolesDAO;
import com.atos.campus.pixies.trainingmanagementsystem.model.LDRoles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController_LDRoles {
	
	@Autowired
	private LDRolesDAO dao;
	
	@RequestMapping("/Crud/LDRoles")
	public String viewHomePage(Model model) {
		List<LDRoles> listLDRoles = dao.list();
		model.addAttribute("listLDRoles", listLDRoles);
	    return "Crud/LDRoles";
	}
	
	@RequestMapping("/Crud/new_LDRoles")
	public String showNewForm(Model model) {
		LDRoles LDRoles = new LDRoles();
	    model.addAttribute("LDRoles", LDRoles);
	     
	    return "New/new_form_LDRoles";
	}
	
	@RequestMapping(value = "/save_LDRoles", method = RequestMethod.POST)
	public String save(@ModelAttribute("LDRoles") LDRoles LDRoles) {
	    dao.save(LDRoles);
	     
	    return "redirect:/Crud/LDRoles";
	}
	
	@RequestMapping("Edit/edit_form_LDRoles/{LDRoleID}")
	public ModelAndView showEditForm(@PathVariable(name = "LDRoleID") int LDRoleID) {
	    ModelAndView mav = new ModelAndView("edit_form_LDRoles");
	    LDRoles LDRoles = dao.get(LDRoleID);
	    mav.addObject("LDRoles", LDRoles);
	     
	    return mav;
	}
	
	@RequestMapping(value = "/update_LDRoles", method = RequestMethod.POST)
	public String update(@ModelAttribute("LDRoles") LDRoles LDRoles) {
	    dao.update(LDRoles);
	     
	    return "redirect:/Crud/LDRoles";
	}
	
	@RequestMapping("/delete_LDRoles/{LDRoleID}")
	public String delete(@PathVariable(name = "LDRoleID") int LDRoleID) {
	    dao.delete(LDRoleID);
	    return "redirect:/Crud/LDRoles";       
	}	
}
