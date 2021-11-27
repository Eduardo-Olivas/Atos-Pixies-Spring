package net.codejava.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.dao.TrainingProposalsDAO;
import net.codejava.model.TrainingProposals;

@RestController
public class RestControllerReactProposals {

	@Autowired
	private TrainingProposalsDAO dao;
	
	@GetMapping("/api/proposals")
	public List<TrainingProposals> getProposals() {
		List<TrainingProposals> list = dao.list();
		
		return list;
	}
}
