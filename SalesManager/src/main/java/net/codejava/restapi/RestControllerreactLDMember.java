package net.codejava.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.dao.LDMemberDataDAO;
import net.codejava.model.LDMemberData;

@RestController
public class RestControllerreactLDMember {
	
	@Autowired
	private LDMemberDataDAO dao;
	
	@GetMapping("/api/LDMember")
	public List<LDMemberData> LDMember() {
		List<LDMemberData> list = dao.list();
		
		return list;
	}
}
