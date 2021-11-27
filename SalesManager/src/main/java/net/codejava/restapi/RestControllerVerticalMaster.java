package net.codejava.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.dao.VerticalMasterDAO;
import net.codejava.model.VerticalMaster;

@RestController
public class RestControllerVerticalMaster {
	
	@Autowired
	private VerticalMasterDAO dao;
	
	@GetMapping("/api/verticalmaster")
	public List<VerticalMaster> getVerticals() {
		List<VerticalMaster> list = dao.list();
		
		return list;
	}
}
