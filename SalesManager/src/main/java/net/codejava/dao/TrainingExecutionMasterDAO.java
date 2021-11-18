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

import net.codejava.model.TrainingExecutionMaster;

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
	
	public void save(TrainingExecutionMaster TrainingExecutionMaster) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("TrainingExecutionMaster").usingColumns("RequirementID", "ExecutionID", "ConfirmedDate","ConfirmedTime","Trainer","TotalHRS","ProposalStatus","TotalParticipantsAllowed");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(TrainingExecutionMaster);
		
		insertActor.execute(param);		
	}
	
	public TrainingExecutionMaster get(String RequirementID) {
		String sql = "SELECT * FROM TrainingExecutionMaster WHERE RequirementID = ?";
		Object[] args = {RequirementID};
		TrainingExecutionMaster TrainingExecutionMaster = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(TrainingExecutionMaster.class));
		return TrainingExecutionMaster;
	}
	
	public void update(TrainingExecutionMaster TrainingExecutionMaster) {
		String sql = "UPDATE TrainingExecutionMaster SET RequirementID=:RequirementID, ExecutionID=:ExecutionID, ConfirmedDate=:ConfirmedDate, ConfirmedTime=:ConfirmedTime, Trainer=:Trainer, TotalHRS=:TotalHRS, ProposalStatus=:ProposalStatus, TotalParticipantsAllowed=:TotalParticipantsAllowed WHERE RequirementID=:RequirementID";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(TrainingExecutionMaster);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);		
	}
	
	public void delete(String RequirementID) {
		String sql = "DELETE FROM TrainingExecutionMaster WHERE RequirementID = ?";
		jdbcTemplate.update(sql, RequirementID);
	}
}
