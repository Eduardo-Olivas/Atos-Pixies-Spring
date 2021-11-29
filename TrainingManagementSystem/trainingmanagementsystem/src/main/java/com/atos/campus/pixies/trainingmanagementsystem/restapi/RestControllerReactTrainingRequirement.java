package com.atos.campus.pixies.trainingmanagementsystem.restapi;

import java.util.List;

import com.atos.campus.pixies.trainingmanagementsystem.dao.TrainingRequirementMasterDAO;
import com.atos.campus.pixies.trainingmanagementsystem.model.TrainingRequirementMaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
