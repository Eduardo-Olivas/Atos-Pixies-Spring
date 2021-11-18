package net.codejava.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.codejava.model.TrainingProposals;

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
	
	public void save(TrainingProposals TrainingProposals) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("TrainingProposals").usingColumns("ProporsalID", "ExecutionID", "MemberID","Email","ProposedDate","ProposedTime","ProposedDuration");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(TrainingProposals);
		
		insertActor.execute(param);		
	}
	
	public TrainingProposals get(String ProporsalID) {
		String sql = "SELECT * FROM TrainingProposals WHERE ProporsalID = ?";
		Object[] args = {ProporsalID};
		TrainingProposals TrainingProposals = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(TrainingProposals.class));
		return TrainingProposals;
	}
	
	public void update(TrainingProposals TrainingProposals) {
		String sql = "UPDATE TrainingProposals SET ProporsalID=:ProporsalID, ExecutionID=:ExecutionID, MemberID=:MemberID, Email=:Email, ProposedDate=:ProposedDate, ProposedTime=:ProposedTime, ProposedDuration=:ProposedDuration WHERE ProporsalID=:ProporsalID";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(TrainingProposals);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);		
	}
	
	public void delete(String ProporsalID) {
		String sql = "DELETE FROM TrainingProposals WHERE ProporsalID = ?";
		jdbcTemplate.update(sql, ProporsalID);
	}
}
