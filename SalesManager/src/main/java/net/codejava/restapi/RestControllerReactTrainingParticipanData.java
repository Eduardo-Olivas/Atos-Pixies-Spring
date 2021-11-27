package net.codejava.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.dao.TrainingParticipantDataDAO;
import net.codejava.model.TrainingParticipantData;

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
