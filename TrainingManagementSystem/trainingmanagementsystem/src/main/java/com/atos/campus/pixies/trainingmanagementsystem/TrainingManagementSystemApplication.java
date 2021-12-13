package com.atos.campus.pixies.trainingmanagementsystem;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrainingManagementSystemApplication {

	private static Logger logJava = Logger.getLogger(TrainingManagementSystemApplication.class);	
	
	public static void main(String[] args) {
		logJava.info("RUN: LOGG TrainingManagementSystemApplication");
		
		SpringApplication.run(TrainingManagementSystemApplication.class, args);
	}

}
