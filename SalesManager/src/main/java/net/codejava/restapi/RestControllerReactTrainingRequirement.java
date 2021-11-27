package net.codejava.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.dao.TrainingRequirementMasterDAO;
import net.codejava.model.TrainingExecutionMaster;
import net.codejava.model.TrainingRequirementMaster;

@RestController
public class RestControllerReactTrainingRequirement {
	
	@Autowired
	private TrainingRequirementMasterDAO dao;

	@GetMapping("/api/TrainingRequirements")
	public List<TrainingRequirementMaster> getTrainings() {
		List<TrainingRequirementMaster>  list = dao.list();
		
		return list;
	}
	
	@GetMapping("/api/TrainingRequirements/{id}")
	public TrainingRequirementMaster getOneTrainingRequirement(@PathVariable String id) {
		TrainingRequirementMaster training = dao.get(id);
		
		return training;
	}
}
