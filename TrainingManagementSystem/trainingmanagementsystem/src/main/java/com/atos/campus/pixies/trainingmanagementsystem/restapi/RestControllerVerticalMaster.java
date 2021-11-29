package com.atos.campus.pixies.trainingmanagementsystem.restapi;

import java.util.List;

import com.atos.campus.pixies.trainingmanagementsystem.dao.VerticalMasterDAO;
import com.atos.campus.pixies.trainingmanagementsystem.model.VerticalMaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerVerticalMaster {
	
	@Autowired
	private VerticalMasterDAO dao;
	
	@GetMapping("/api/verticalmaster")
	public List<VerticalMaster> getVerticals() {
		List<VerticalMaster> list = dao.list();
		
		return list;
	}
}
