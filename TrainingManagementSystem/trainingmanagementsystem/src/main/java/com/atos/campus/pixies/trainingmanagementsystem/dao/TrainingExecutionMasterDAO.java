package com.atos.campus.pixies.trainingmanagementsystem.dao;

import java.util.List;

import com.atos.campus.pixies.trainingmanagementsystem.model.TrainingExecutionMaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class TrainingExecutionMasterDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<TrainingExecutionMaster> list() {
		String sql = "SELECT * FROM TrainingExecutionMaster";

		List<TrainingExecutionMaster> listTrainingExecutionMaster = jdbcTemplate.query(sql, 
				BeanPropertyRowMapper.newInstance(TrainingExecutionMaster.class));

		return listTrainingExecutionMaster;
	}
	
	public List<TrainingExecutionMaster> getByProposalID(String proposalID) {
		String query = "SELECT * FROM TrainingExecutionMaster WHERE ProposalID = ?";
		Object[] args = {proposalID};
		List<TrainingExecutionMaster> res = jdbcTemplate.query(query, args, BeanPropertyRowMapper.newInstance(TrainingExecutionMaster.class));
		return res;
	}
	
	public void save(TrainingExecutionMaster TrainingExecutionMaster) { 
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("TrainingExecutionMaster").usingColumns("ExecutionID", "ProposalID", "ConfirmedDate","ConfirmedTime","Trainer","TotalHRS","ProposalStatus","TotalParticipantsAllowed", "TrainerResponse");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(TrainingExecutionMaster);
		
		insertActor.execute(param);		
	}
	
	public TrainingExecutionMaster get(String ExecutionID) {
		String sql = "SELECT * FROM TrainingExecutionMaster WHERE ExecutionID = ?";
		Object[] args = {ExecutionID};
		TrainingExecutionMaster TrainingExecutionMaster = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(TrainingExecutionMaster.class));
		return TrainingExecutionMaster;
	}

	public List<TrainingExecutionMaster> getByTrainer(String TrainerID) {
		String sql = "SELECT * FROM TrainingExecutionMaster WHERE Trainer = ?";
		Object[] args = {TrainerID};
		return jdbcTemplate.query(sql, args, BeanPropertyRowMapper.newInstance(TrainingExecutionMaster.class));
	}
	
	public TrainingExecutionMaster getOne(String ExecutionID) {
		String sql = "SELECT * FROM TrainingExecutionMaster WHERE ExecutionID = ?";
		Object[] args = {ExecutionID};
		TrainingExecutionMaster TrainingExecutionMaster = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(TrainingExecutionMaster.class));
		return TrainingExecutionMaster;
	}
	
	public List <TrainingExecutionMaster> getOneForeign(String ProposalID) {
		String sql = "SELECT * FROM TrainingExecutionMaster WHERE ProposalID = ?";
		Object[] args = {ProposalID};
		List <TrainingExecutionMaster> listExecutions = jdbcTemplate.query(sql, args, BeanPropertyRowMapper.newInstance(TrainingExecutionMaster.class));
		return listExecutions;
	}
	
	public void update(TrainingExecutionMaster TrainingExecutionMaster) {
		String sql = "UPDATE TrainingExecutionMaster SET ExecutionID=:ExecutionID, ProposalID=:ProposalID, ConfirmedDate=:ConfirmedDate, ConfirmedTime=:ConfirmedTime, Trainer=:Trainer, TotalHRS=:TotalHRS, ProposalStatus=:ProposalStatus, TotalParticipantsAllowed=:TotalParticipantsAllowed, TrainerResponse:=TrainerResponse WHERE ExecutionID=:ExecutionID";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(TrainingExecutionMaster);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);		
	}
	
	public void delete(String ExecutionID) {
		String sql = "DELETE FROM TrainingExecutionMaster WHERE ExecutionID = ?";
		jdbcTemplate.update(sql, ExecutionID);
	}
}
