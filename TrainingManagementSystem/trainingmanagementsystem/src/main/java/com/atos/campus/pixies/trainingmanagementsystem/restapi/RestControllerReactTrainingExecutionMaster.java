package com.atos.campus.pixies.trainingmanagementsystem.restapi;

import java.util.List;

import com.atos.campus.pixies.trainingmanagementsystem.dao.TrainingExecutionMasterDAO;
import com.atos.campus.pixies.trainingmanagementsystem.model.TrainingExecutionMaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerReactTrainingExecutionMaster {
	
	@Autowired
	private TrainingExecutionMasterDAO dao;
	
	@GetMapping("/api/TrainingExecutionMaster")
	public List<TrainingExecutionMaster> getAll() {
		
		List<TrainingExecutionMaster> list = dao.list();
		return list;
	}
	
	@GetMapping("/api/TrainingExecutionMaster/{id}")
	public TrainingExecutionMaster getOne(@PathVariable String id) {
		TrainingExecutionMaster training = dao.getOne(id);
		
		return training;
	}
}
