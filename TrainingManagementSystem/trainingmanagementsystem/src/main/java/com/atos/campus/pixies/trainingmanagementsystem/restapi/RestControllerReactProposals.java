package com.atos.campus.pixies.trainingmanagementsystem.restapi;

import java.util.List;

import com.atos.campus.pixies.trainingmanagementsystem.dao.TrainingProposalsDAO;
import com.atos.campus.pixies.trainingmanagementsystem.model.TrainingProposals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerReactProposals {

	@Autowired
	private TrainingProposalsDAO dao;
	
	@GetMapping("/api/proposals")
	public List<TrainingProposals> getProposals() {
		List<TrainingProposals> list = dao.list();
		
		return list;
	}
	
	@GetMapping("/api/proposals/{id}")
	public TrainingProposals getProposal(@PathVariable String id) {
		TrainingProposals element = dao.getOneSpecial(id);
		
		return element;
	}
	
	@GetMapping("/api/proposals/foreign-key/{id}")
	public List<TrainingProposals> getProposalsSpecial(@PathVariable String id) {
		List<TrainingProposals> list = dao.listSpecial(id);
		
		return list;
	}
}
