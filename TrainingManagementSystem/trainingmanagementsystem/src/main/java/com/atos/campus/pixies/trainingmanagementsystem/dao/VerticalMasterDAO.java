package com.atos.campus.pixies.trainingmanagementsystem.dao;

import java.util.List;

import com.atos.campus.pixies.trainingmanagementsystem.model.VerticalMaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class VerticalMasterDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<VerticalMaster> list() {
		String sql = "SELECT * FROM VerticalMaster";

		List<VerticalMaster> listVerticalMaster = jdbcTemplate.query(sql, 
				BeanPropertyRowMapper.newInstance(VerticalMaster.class));

		return listVerticalMaster;
	}

	public List<VerticalMaster> listByLPID(String id) {
		String sql = "SELECT * FROM VerticalMaster WHERE VerticalLBPID = '" + id +"'";

		List<VerticalMaster> listVerticalMaster = jdbcTemplate.query(sql, 
				BeanPropertyRowMapper.newInstance(VerticalMaster.class));

		return listVerticalMaster;
	}
	
	public void save(VerticalMaster VerticalMaster) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("VerticalMaster").usingColumns("VID", "VerticalName", "VerticalLBPID");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(VerticalMaster);
		
		insertActor.execute(param);		
	}
	
	public VerticalMaster get(String VID) {
		String sql = "SELECT * FROM VerticalMaster WHERE VID = ?";
		Object[] args = {VID};
		VerticalMaster VerticalMaster = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(VerticalMaster.class));
		return VerticalMaster;
	}
	
	public void update(VerticalMaster VerticalMaster) {
		String sql = "UPDATE VerticalMaster SET VID=:VID, "
				+ "VerticalName=:VerticalName, VerticalLBPID=:VerticalLBPID "
				+ "WHERE VID=:VID";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(VerticalMaster);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);		
	}
	
	public void delete(String VID) {
		String sql = "DELETE FROM VerticalMaster WHERE VID = ?";
		jdbcTemplate.update(sql, VID);
	}
}
