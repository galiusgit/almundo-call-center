package com.almundo.callcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * The Class CallcenterApplication. 
 * Initializes the spring boot application
 * 
 * @version 0.0.1
 */
@SpringBootApplication
public class CallcenterApplication extends SpringBootServletInitializer {
	
	/**
	 * configuration
	 *
	 * @param application the application
	 * @return the spring application builder
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CallcenterApplication.class);
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(CallcenterApplication.class, args);
	}
}
