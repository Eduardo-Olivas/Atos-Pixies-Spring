package net.codejava.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.dao.TrainingRequirementMasterDAO;
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
}
