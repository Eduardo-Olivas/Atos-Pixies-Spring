package com.atos.campus.pixies.trainingmanagementsystem.dao;

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
	
	public List<TrainingProposals> listSpecial(String id) {
		String sql = "SELECT * FROM TrainingProposals WHERE ProporsalID = ?";
		Object[] args = {id};
		List<TrainingProposals> listTrainingProposals = jdbcTemplate.query(sql,args,
				BeanPropertyRowMapper.newInstance(TrainingProposals.class));

		return listTrainingProposals;
	}
	
	public void save(TrainingProposals TrainingProposals) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("TrainingProposals").usingColumns("ProporsalID", "RequirementID", "MemberID","ProposedDate","ProposedTime","ProposedDuration","ProposalStatus");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(TrainingProposals);
		
		insertActor.execute(param);		
	}
	
	public TrainingProposals get(String ProporsalID) {
		String sql = "SELECT * FROM TrainingProposals WHERE ProporsalID = ?";
		Object[] args = {ProporsalID};
		TrainingProposals TrainingProposals = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(TrainingProposals.class));
		return TrainingProposals;
	}
	
	public TrainingProposals getOneSpecial(String ProporsalID) {
		String sql = "SELECT * FROM TrainingProposals WHERE ProporsalID = ?";
		Object[] args = {ProporsalID};
		TrainingProposals TrainingProposals = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(TrainingProposals.class));
		return TrainingProposals;
	}
	
	public void update(TrainingProposals TrainingProposals) {
		String sql = "UPDATE TrainingProposals SET ProporsalID=:ProporsalID, RequirementID=:RequirementID, MemberID=:MemberID, Email=:Email, ProposedDate=:ProposedDate, ProposedTime=:ProposedTime, ProposedDuration=:ProposedDuration, ProposalStatus:=ProposalStatus WHERE ProporsalID=:ProporsalID";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(TrainingProposals);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);		
	}
	
	public void delete(String ProporsalID) {
		String sql = "DELETE FROM TrainingProposals WHERE ProporsalID = ?";
		jdbcTemplate.update(sql, ProporsalID);
	}
}
