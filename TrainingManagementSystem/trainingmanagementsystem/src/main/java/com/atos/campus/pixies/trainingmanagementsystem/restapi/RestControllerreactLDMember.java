package com.atos.campus.pixies.trainingmanagementsystem.restapi;

import java.util.List;

import com.atos.campus.pixies.trainingmanagementsystem.dao.LDMemberDataDAO;
import com.atos.campus.pixies.trainingmanagementsystem.model.LDMemberData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerreactLDMember {
	
	@Autowired
	private LDMemberDataDAO dao;
	
	@GetMapping("/api/LDMember")
	public List<LDMemberData> LDMember() {
		List<LDMemberData> list = dao.list();
		
		return list;
	}
}
