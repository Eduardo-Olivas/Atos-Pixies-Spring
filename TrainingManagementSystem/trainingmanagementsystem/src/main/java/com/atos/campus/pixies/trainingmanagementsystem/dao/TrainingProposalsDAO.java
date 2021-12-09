package com.atos.campus.pixies.trainingmanagementsystem.dao;

import java.util.ArrayList;
import java.util.List;

import com.atos.campus.pixies.trainingmanagementsystem.model.TrainingProposals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class TrainingProposalsDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<TrainingProposals> list() {
		String sql = "SELECT * FROM TrainingProposals";

		List<TrainingProposals> listTrainingProposals = jdbcTemplate.query(sql, 
				BeanPropertyRowMapper.newInstance(TrainingProposals.class));

		return listTrainingProposals;
	}
	
	public List<TrainingProposals> listRejected() {
		String sql = "SELECT * FROM TrainingProposals WHERE ProposalStatus = 'Rejected'";

		List<TrainingProposals> listTrainingProposals = jdbcTemplate.query(sql, 
				BeanPropertyRowMapper.newInstance(TrainingProposals.class));

		return listTrainingProposals;
	}
	
	public List<TrainingProposals> listRejectedRequirementID(String requirementID) {
		String query = "SELECT * FROM TrainingProposals WHERE RequirementID = ? AND ProposalStatus = 'Rejected'";
		Object[] args = {requirementID};
		List<TrainingProposals> res = jdbcTemplate.query(query, args, BeanPropertyRowMapper.newInstance(TrainingProposals.class));

		return res;
	}
	
	public List<TrainingProposals> getByRequirementID(String requirementID) {
		String query = "SELECT * FROM TrainingProposals WHERE RequirementID = ?";
		Object[] args = {requirementID};
		List<TrainingProposals> res = jdbcTemplate.query(query, args, BeanPropertyRowMapper.newInstance(TrainingProposals.class));
		return res;
	}
	
	public List<TrainingProposals> listSpecial(String id) {
		String sql = "SELECT * FROM TrainingProposals WHERE RequirementID = ?";
		Object[] args = {id};
		List<TrainingProposals> listTrainingProposals = jdbcTemplate.query(sql,args,
				BeanPropertyRowMapper.newInstance(TrainingProposals.class));

		return listTrainingProposals;
	}
	
	public void save(TrainingProposals TrainingProposals) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("TrainingProposals").usingColumns("ProposalID", "RequirementID", "MemberID","ProposedDate","ProposedTime","ProposedDuration","ProposalStatus");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(TrainingProposals);
		
		insertActor.execute(param);		
	}
	
	public TrainingProposals get(String query, String param) {
		Object[] args = {param};
		TrainingProposals TrainingProposals = jdbcTemplate.queryForObject(query, args, BeanPropertyRowMapper.newInstance(TrainingProposals.class));
		return TrainingProposals;
	}

	public TrainingProposals get(String ProposalID) {
		return get("SELECT * FROM TrainingProposals WHERE ProposalID = ?", ProposalID);
	}

	public TrainingProposals getBy(String ProposalID) {
		String sql = "SELECT * FROM TrainingProposals WHERE ProposalID = ?";
		Object[] args = {ProposalID};
		TrainingProposals TrainingProposals = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(TrainingProposals.class));
		return TrainingProposals;
	}
	
	public TrainingProposals getOneSpecial(String ProposalID) {
		String sql = "SELECT * FROM TrainingProposals WHERE ProposalID = ?";
		Object[] args = {ProposalID};
		TrainingProposals TrainingProposals = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(TrainingProposals.class));
		return TrainingProposals;
	}
	
	public void update(TrainingProposals TrainingProposals) {
		String sql = "UPDATE TrainingProposals SET ProposalID=:ProposalID, RequirementID=:RequirementID, MemberID=:MemberID, ProposedDate=:ProposedDate, ProposedTime=:ProposedTime, ProposedDuration=:ProposedDuration, ProposalStatus:=ProposalStatus WHERE ProposalID=:ProposalID";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(TrainingProposals);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);		
	}
	
	public void delete(String ProposalID) {
		String sql = "DELETE FROM TrainingProposals WHERE ProposalID = ?";
		jdbcTemplate.update(sql, ProposalID);
	}
}
