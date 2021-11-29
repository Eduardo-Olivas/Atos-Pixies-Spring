package com.atos.campus.pixies.trainingmanagementsystem.restapi;

import java.util.List;

import com.atos.campus.pixies.trainingmanagementsystem.dao.LDRolesDAO;
import com.atos.campus.pixies.trainingmanagementsystem.model.LDRoles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerReactLDRoles {
	
	@Autowired
	private LDRolesDAO dao;
	
	@GetMapping("/api/LDRoles")
	public List<LDRoles> getLDRoles() {
		List<LDRoles> list = dao.list();
		
		return list;
	}
}
