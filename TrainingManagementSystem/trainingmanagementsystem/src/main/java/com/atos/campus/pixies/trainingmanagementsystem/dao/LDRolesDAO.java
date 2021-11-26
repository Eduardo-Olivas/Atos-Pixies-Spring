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

import net.codejava.model.LDRoles;

@Repository
public class LDRolesDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<LDRoles> list() {
		String sql = "SELECT * FROM LDRoles";

		List<LDRoles> listLDRoles = jdbcTemplate.query(sql, 
				BeanPropertyRowMapper.newInstance(LDRoles.class));

		return listLDRoles;
	}
	
	public void save(LDRoles LDRoles) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("LDRoles").usingColumns("LDRoleID", "LDRoleName", "LDRoleDescription");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(LDRoles);
		
		insertActor.execute(param);		
	}
	
	public LDRoles get(int LDRoleID) {
		String sql = "SELECT * FROM LDRoles WHERE LDRoleID = ?";
		Object[] args = {LDRoleID};
		LDRoles LDRoles = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(LDRoles.class));
		return LDRoles;
	}
	
	public void update(LDRoles LDRoles) {
		String sql = "UPDATE LDRoles SET LDRoleID=:LDRoleID, LDRoleName=:LDRoleName, LDRoleDescription=:LDRoleDescription WHERE LDRoleID=:LDRoleID";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(LDRoles);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);		
	}
	
	public void delete(int LDRoleID) {
		String sql = "DELETE FROM LDRoles WHERE LDRoleID = ?";
		jdbcTemplate.update(sql, LDRoleID);
	}
}
