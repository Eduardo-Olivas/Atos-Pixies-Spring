package com.atos.campus.pixies.trainingmanagementsystem.dao;

import java.util.List;

import com.atos.campus.pixies.trainingmanagementsystem.model.LDMemberData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class LDMemberDataDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<LDMemberData> list() {
		String sql = "SELECT * FROM LDMemberData";

		List<LDMemberData> listLDMemberData = jdbcTemplate.query(sql, 
				BeanPropertyRowMapper.newInstance(LDMemberData.class));

		return listLDMemberData;
	}
	public List<LDMemberData> getLDRoleID(String MembeLDRoleID) {
		String sql = "select * from  LDMemberData where LDRoleID= ?";
		Object[] args = {MembeLDRoleID};
		List listLDMemberData = jdbcTemplate.query(sql,args,BeanPropertyRowMapper.newInstance(LDMemberData.class));
		return listLDMemberData;
	}
	public void save(LDMemberData LDMemberData) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("LDMemberData").usingColumns("MemberID", "MemberName", "MemberContact","MemberLocation","MemberEmail","LDRoleID");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(LDMemberData);
		
		insertActor.execute(param);		
	}
	
	public LDMemberData get(String MemberID) {
		String sql = "SELECT * FROM LDMemberData WHERE MemberID = ?";
		Object[] args = {MemberID};
		LDMemberData LDMemberData = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(LDMemberData.class));
		return LDMemberData;
	}
	

	public LDMemberData getByEmail(String MemberEmail) {
		String sql = "SELECT * FROM LDMemberData WHERE MemberEmail = ?";
		Object[] args = {MemberEmail};
		LDMemberData LDMemberData = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(LDMemberData.class));
		return LDMemberData;
	}
	
	public void update(LDMemberData LDMemberData) {
		String sql = "UPDATE LDMemberData SET MemberID=:MemberID, MemberName=:MemberName, MemberContact=:MemberContact, MemberLocation=:MemberLocation, MemberEmail=:MemberEmail, LDRoleID=:LDRoleID WHERE MemberID=:MemberID";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(LDMemberData);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);		
	}
	
	public void delete(String MemberID) {
		String sql = "DELETE FROM LDMemberData WHERE MemberID = ?";
		jdbcTemplate.update(sql, MemberID);
	}
}
