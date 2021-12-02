package com.atos.campus.pixies.trainingmanagementsystem.dao;

import java.util.List;

import com.atos.campus.pixies.trainingmanagementsystem.model.TrainingRequirementMaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class TrainingRequirementMasterDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<TrainingRequirementMaster> list() {
		String sql = "SELECT * FROM TrainingRequirementMaster";

		List<TrainingRequirementMaster> listTrainingRequirementMaster = jdbcTemplate.query(sql, 
				BeanPropertyRowMapper.newInstance(TrainingRequirementMaster.class));

		return listTrainingRequirementMaster;
	}
	
	public void save(TrainingRequirementMaster TrainingRequirementMaster) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("TrainingRequirementMaster").usingColumns("RequirementID", "RequirementReceivedDate", 
				"RequirementUser","RequirementUserVertical","TrainingArea","TrainingDescription","RequestedTrainingStartDate",
				"TotalCandidates","TrainingTimeZone","TotalDurationDays");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(TrainingRequirementMaster);
		
		insertActor.execute(param);		
	}
	
	public TrainingRequirementMaster get(String RequirementID) {
		String sql = "SELECT * FROM TrainingRequirementMaster WHERE RequirementID = ?";
		Object[] args = {RequirementID};
		TrainingRequirementMaster TrainingRequirementMaster = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(TrainingRequirementMaster.class));
		return TrainingRequirementMaster;
	}
	
	public void update(TrainingRequirementMaster TrainingRequirementMaster) {
		String sql = "UPDATE TrainingRequirementMaster SET RequirementID=:RequirementID, "
				+ "RequirementReceivedDate=:RequirementReceivedDate, RequirementUser=:RequirementUser, "
				+ "RequirementUserVertical=:RequirementUserVertical, TrainingArea=:TrainingArea, "
				+ "TrainingDescription=:TrainingDescription, "
				+ "RequestedTrainingStartDate=:RequestedTrainingStartDate, "
				+ "TotalCandidates=:TotalCandidates,"
				+ "TrainingTimeZone=:TrainingTimeZone,"
				+ "TotalDurationDays=:TotalDurationDays "
				+ "WHERE RequirementID=:RequirementID";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(TrainingRequirementMaster);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);		
	}
	
	public void delete(String RequirementID) {
		String sql = "DELETE FROM TrainingRequirementMaster WHERE RequirementID = ?";
		jdbcTemplate.update(sql, RequirementID);
	}
}
