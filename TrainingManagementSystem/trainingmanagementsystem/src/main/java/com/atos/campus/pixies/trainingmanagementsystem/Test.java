package com.atos.campus.pixies.trainingmanagementsystem;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class Test {

    public static void main(String[] args) {
		JdbcTemplate test = new JdbcTemplate();
		String r = test.queryForObject("select * from emp", String.class);
		System.out.println(r);
		System.out.println("Done...");
	}
}