package com.atos.campus.pixies.trainingmanagementsystem.restapi;

import java.util.List;

import com.atos.campus.pixies.trainingmanagementsystem.dao.TrainingParticipantDataDAO;
import com.atos.campus.pixies.trainingmanagementsystem.model.TrainingParticipantData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerReactTrainingParticipanData {
	
	@Autowired
	private TrainingParticipantDataDAO dao;
	
	@GetMapping("/api/ParticipantData")
	public List<TrainingParticipantData> getParticipantData() {
		List<TrainingParticipantData> list = dao.list();
		
		return list;
	}
}
