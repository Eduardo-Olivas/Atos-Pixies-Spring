package com.atos.campus.pixies.trainingmanagementsystem.dao;

import java.util.List;

import com.atos.campus.pixies.trainingmanagementsystem.model.TrainingParticipantData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class TrainingParticipantDataDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<TrainingParticipantData> list() {
		String sql = "SELECT * FROM TrainingParticipantData";

		List<TrainingParticipantData> listTrainingParticipantData = jdbcTemplate.query(sql, 
				BeanPropertyRowMapper.newInstance(TrainingParticipantData.class));

		return listTrainingParticipantData;
	}
	
	public void save(TrainingParticipantData TrainingParticipantData) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("TrainingParticipantData").usingColumns("ParticipantID", "EmployeeID", "EmployeeName","Email","Contact","RequirementID","AttendanceStatus");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(TrainingParticipantData);
		
		insertActor.execute(param);		
	}
	
	public TrainingParticipantData get(String ParticipantID) {
		String sql = "SELECT * FROM TrainingParticipantData WHERE ParticipantID = ?";
		Object[] args = {ParticipantID};
		TrainingParticipantData TrainingParticipantData = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(TrainingParticipantData.class));
		return TrainingParticipantData;
	}
	
	public void update(TrainingParticipantData TrainingParticipantData) {
		String sql = "UPDATE TrainingParticipantData SET ParticipantID=:ParticipantID, EmployeeID=:EmployeeID, EmployeeName=:EmployeeName, Email=:Email, Contact=:Contact, RequirementID=:RequirementID, AttendanceStatus=:AttendanceStatus WHERE ParticipantID=:ParticipantID";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(TrainingParticipantData);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);		
	}
	
	public void delete(String ParticipantID) {
		String sql = "DELETE FROM TrainingParticipantData WHERE ParticipantID = ?";
		jdbcTemplate.update(sql, ParticipantID);
	}
}
