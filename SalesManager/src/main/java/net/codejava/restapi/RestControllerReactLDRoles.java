package net.codejava.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.dao.LDRolesDAO;
import net.codejava.model.LDRoles;

@RestController
public class RestControllerReactLDRoles {
	
	@Autowired
	private LDRolesDAO dao;
	
	@GetMapping("/api/LDRoles")
	public List<LDRoles> getLDRoles() {
		List<LDRoles> list = dao.list();
		
		return list;
	}
}
