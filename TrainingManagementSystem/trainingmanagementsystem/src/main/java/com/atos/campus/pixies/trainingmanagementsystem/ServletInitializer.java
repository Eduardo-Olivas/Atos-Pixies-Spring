package com.atos.campus.pixies.trainingmanagementsystem;

import org.apache.log4j.Logger;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	private static Logger logJava = Logger.getLogger(ServletInitializer.class);	
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		
		logJava.info("RUN ServletInitializer");
		
		return application.sources(TrainingManagementSystemApplication.class);
	}

}
