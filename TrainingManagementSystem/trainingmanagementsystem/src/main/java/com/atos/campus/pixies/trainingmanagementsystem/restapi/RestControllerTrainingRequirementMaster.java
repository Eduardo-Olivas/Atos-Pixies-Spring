package com.atos.campus.pixies.trainingmanagementsystem.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.atos.campus.pixies.trainingmanagementsystem.dao.TrainingRequirementMasterDAO;
import com.atos.campus.pixies.trainingmanagementsystem.model.TrainingRequirementMaster;
@RestController
public class RestControllerTrainingRequirementMaster {

@Autowired
private TrainingRequirementMasterDAO dao;
@GetMapping("/apiTrainingRequirementMaster/{id}")
public TrainingRequirementMaster listTrainingRequirementMaster(@PathVariable String id){
	TrainingRequirementMaster training=dao.get(id);
	return training;
}

}
